<?php 
header( 'Content-Type: text/html;charset=utf-8' );

//host , user, passw, database

function ejecutarSQLCommand($commando){
 
  $mysqli = new mysqli("bmcwlgw91ck265gnuv4v-mysql.services.clever-cloud.com", "u6jvkupftj0eoyix", "0JWRENC3x5IUENIoJAUV", "bmcwlgw91ck265gnuv4v");

/* check connection */
if ($mysqli->connect_error) {
    printf("Connect failed: %s\n", $mysqli->connect_error);
echo li;
    exit();
}

if ( $mysqli->multi_query($commando)) {
     if ($resultset = $mysqli->store_result()) {
    	while ($row = $resultset->fetch_array(MYSQLI_BOTH)) {
echo listo;
    		
    	}
    	$resultset->free();
     }
    
   
}



$mysqli->close();
}

function getSQLResultSet($commando){
 
 
  $mysqli = new mysqli("bmcwlgw91ck265gnuv4v-mysql.services.clever-cloud.com", "u6jvkupftj0eoyix", "0JWRENC3x5IUENIoJAUV", "bmcwlgw91ck265gnuv4v");

/* check connection */
if ($mysqli->connect_errno) {
    printf("Connect failed: %s\n", $mysqli->connect_error);
    exit();
}

if ( $mysqli->multi_query($commando)) {
	return $mysqli->store_result();
	
     
    
   
}



$mysqli->close();
}


?>
