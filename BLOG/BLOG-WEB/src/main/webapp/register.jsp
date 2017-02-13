<!DOCTYPE html>
<html>
<head>
	<title>Register New User</title>
</head>
<body>
<h1>Register</h1>
<h3>Please fill in your proper details</h3>
<form action="/home/register" method="POST">
	
	<input type="text" name="Name" id="Name" placeholder="Type your name here" required autofocus ><br><br>
	<input type="text" name="EmailId" placeholder="Email Id" required autofocus /><br><br>
	<input type="password" name="Password" placeholder="Password" required /><br><br>
	<button type="submit" value="Submit">Submit</button><br><br> 

</form>

<div><span style="color:red">${EXCEPTION_LIST}</span></div>

</body>
</html>