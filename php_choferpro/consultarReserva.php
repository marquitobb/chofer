<?php
include('functions.php'); 
if ($resultset = getSQLResultSet("SELECT * FROM `productos`")) {
	
    	while ($row = $resultset->fetch_array(MYSQLI_NUM)) {
    	echo json_encode($row);
		
    	
    	}
    	
   }
   
?>
