<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Log In</title>
</head>

<body>
<h1>Welcome</h1>
<h3>Log In</h3>
<form action="/home/login" method="POST">
	
	<input type="text" name="EmailId" placeholder="Email Id" required autofocus /><br><br>
	<input type="password" name="Password" placeholder="Password" required /><br><br>
	<button type="submit" value="LogIn">Log In</button><br><br> 

</form>
<input type="button" name="Register" value="Register" onclick="window.location.href='register.jsp'">
</body>
</html>
