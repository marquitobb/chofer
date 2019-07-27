<?php
    include'conexion.php';
    $correo = $_GET['correo'];
    //$contra = $_GET['contra'];

    $consulta = "select correo from usuario where correo = '$correo'";
    $resultado = $conexion -> query($consulta);

    while ($fila=$resultado -> fetch_array()) {
        $usu[] = array_map('utf8_encode', $fila);
    }
    
    echo json_encode($usu);
    $resultado -> close();
    
?>