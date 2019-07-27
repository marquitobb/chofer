<?php include ('functions.php');
$idr=$_GET['idr'];
$NHab=$_GET['NHab'];
$fe=$_GET['fe'];
$fs=$_GET['fs'];

ejecutarSQLCommand("INSERT INTO  `reservas` (
`idReserva`,
`NoHab` ,
`FechaEntrada` ,
`FechaSalida`
)
VALUES (
'$idr' ,
'$NHab' ,
'$fe' ,
'$fs')

 ON DUPLICATE KEY UPDATE `idReserva`= '$idr',
`NoHab`='$NHab' ,
`FechaEntrada`='$fe',
`FechaSalida`='$fs'
;");

 ?>
