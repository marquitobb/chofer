<?php
    include'conexion.php';

    $ubic = null;
    $nombre = $_POST['nombre'];
    $precio = $_POST['precio'];
    $usuario = $_POST['usuario'];

    $consulta = "insert into productos values('".$nombre."','".$precio."','".$usuario."','".$ubic."')";
    mysqli_query($conexion,$consulta) or die (mysqli_error());
    mysqli_close($conexion);
?>