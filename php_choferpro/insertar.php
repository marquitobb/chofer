<?php
    include'conexion.php';

    $id = null;
    $nombre = $_POST['nombre'];
    $contra = $_POST['contra'];
    $correo = $_POST['correo'];

    $consulta = "insert into usuario values('".$correo."','".$nombre."','".$contra."')";
    mysqli_query($conexion,$consulta) or die (mysqli_error());
    mysqli_close($conexion);
?>