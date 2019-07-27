<?php

$nombre = $_POST['nombre'];
$ubicacion = $_POST['ubicacion'];

$servername = "bjxlbaldfrp9sqfnparg-mysql.services.clever-cloud.com";
$username = "u8wnkl4lf9epbcen";
$password = "tN7hKcOTQozZDYSTROIm";
$dbname = "bjxlbaldfrp9sqfnparg";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "UPDATE productos SET ubicacion='".$ubicacion."' WHERE usuario='".$nombre."'";

if ($conn->query($sql) === TRUE) {
    echo "Record updated successfully";
} else {
    echo "Error updating record: " . $conn->error;
}

$conn->close();
?>