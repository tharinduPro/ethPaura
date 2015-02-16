<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>


</head>

<body>

<?php 
$xml = file_get_contents("http://192.168.172.1:8080/ethpaura-1.0.0-BUILD-SNAPSHOT/addAttackDetails/1/West/6.123456/81.258963");
$dir = $_GET["dir"];

$village = $_GET["village"];

$xml = file_get_contents("http://www.mtours.lk/wifi/smsss.php?dir=".$dir."&village=".$village."");


$servername = "localhost";
$username = "root";
$password = "";
$dbname = "test";
/*

$name = $_GET["name"];
$email = $_GET["email"];


*/


// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

echo "jgfgb";

$sql = "INSERT INTO wifi (name, email) VALUES (12, 25)";


if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
	echo "<object width='420' height='315'
data='http://ananmanan1.com/mp3/201411/Daddy_Aradhana_ananmanan.lk.mp3'>
</object>";
	
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}



$conn->close();

 ?>
 
 


</body>
</html>