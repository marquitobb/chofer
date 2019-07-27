<?php
    include'conexion.php';
    $nombre = $_GET['nombre'];

    $consulta = "select * from usuario where nombre = '$nombre'";
    $resultado = $conexion -> query($consulta);

    while ($fila=$resultado -> fetch_array()) {
        $usu[] = array_map('utf8_encode', $fila);
    }
    
    echo json_encode($usu);
    $resultado -> close();
    
?>