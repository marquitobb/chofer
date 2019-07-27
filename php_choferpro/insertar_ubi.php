<?php
    include'conexion.php';

   
    $nombre = $_POST['nombre'];
    $dir = $_POST['direccion'];
    $correo = $_POST['correo'];
    $lonlat = $_POST['lonlat'];

    $consulta = "insert into ubicaciones values('".$nombre."','".$dir."','".$correo."','".$lonlat."')";
    mysqli_query($conexion,$consulta) or die (mysqli_error());
    mysqli_close($conexion);
?>