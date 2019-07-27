<?php
    
    $hostname = 'bmcwlgw91ck265gnuv4v-mysql.services.clever-cloud.com';
    $database = 'bmcwlgw91ck265gnuv4v';
    $username = 'u6jvkupftj0eoyix';
    $password = '0JWRENC3x5IUENIoJAUV';
    
    /*$hostname = 'localhost';
    $database = 'id10101154_jeje';
    $username = 'id10101154_con2';
    $password = '123456789';*/

    $conexion = new mysqli($hostname, $username, $password, $database);

    if ($conexion->connect_errno) {
        echo "lo sentimos error de php";
    }
?>