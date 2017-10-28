<?
$hostName = "db2711.1und1.de";
$userName = "dbo364758940";
$password = "rsistCool";
$dbName = "db364758940";
$ip=@$REMOTE_ADDR;

mysql_connect($hostName,$userName,$password) or die("Unable to connect to host $hostName");

mysql_select_db($dbName) or die("Unable to select database $dbName");

$d=date( 'Y-m-d H:i:s');

$update = mysql_query("Update mapping SET ip='$ip', description='$_POST[description]', date='$d' WHERE name='$_POST[name]' AND password='$_POST[password]'");

// Close the database connection
mysql_close();

?>

<script type="text/javascript">
	window.location = "http://localhost/view?startup=view";
</script>
