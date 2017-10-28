<?
	//This script takes an arbitrary query and performs the query on the data base.
	$hostName = "db2711.1und1.de";
	$userName = "dbo364758940";
	$password = "rsistCool";
	$dbName = "db364758940";

	mysql_connect($hostName,$userName,$password) or die("Unable to connect to host $hostName");

	mysql_select_db($dbName) or die("Unable to select database $dbName");

	$result = mysql_query(stripslashes($query));

	// Close the database connection
	mysql_close();
?>