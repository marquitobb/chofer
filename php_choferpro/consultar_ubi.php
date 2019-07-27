<?php
include('functions.php'); 
$correo=$_GET['correo'];
if ($resultset = getSQLResultSet("SELECT * FROM `ubicaciones` WHERE correo_usu='$correo'")) {
	
    	while ($row = $resultset->fetch_array(MYSQLI_NUM)) {
    	echo json_encode($row);
		
    	
    	}
    	
   }
   
?>