<?php
include('functions.php'); 
$user=$_GET['usuario'];
if ($resultset = getSQLResultSet("SELECT * FROM `productos` WHERE usuario='$user'")) {
	
    	while ($row = $resultset->fetch_array(MYSQLI_NUM)) {
    	echo json_encode($row);
		
    	
    	}
    	
   }
   
?>