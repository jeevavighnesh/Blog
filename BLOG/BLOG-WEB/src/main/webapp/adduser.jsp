<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello yos</title>
</head>
<body>

	<form action="users/save" method="GET">
		Id : <input type="number" name="id" required autofocus />
		Name : <input type="text" name="name" required />
		Email :	<input type="text" name="emailid" required />
		Password :	<input type="password" name="password" required/ >
		<button type="submit">Submit</button>

	</form>

	<a href="users">User List</a>
</body>
</html>