<?php
    include'conexion.php';
    $correo = $_GET['correo'];
    $contra = $_GET['contra'];

    $consulta = "select contra from usuario where correo = '$correo' and contra = '$contra'";
    $resultado = $conexion -> query($consulta);

    while ($fila=$resultado -> fetch_array()) {
        $usu[] = array_map('utf8_encode', $fila);
    }
    
    echo json_encode($usu);
    $resultado -> close();
    
?>