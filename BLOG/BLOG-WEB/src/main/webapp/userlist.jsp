<%@page import="com.aynna.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List Page</title>
</head>
<body>
	<h3>User List JSP</h3>
	To Test Values : ${USER_LIST}
	<table border="1">
		<thead>
			<tr>
				<th>Sno</th>
				<th>User Id</th>
				<th>User Name</th>
				<th>User EmailId</th>
				<th>User Password</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="u" items="${USER_LIST}" varStatus="i">
				<tr>
					<td>${i.index+1}</td>
					<td>${u.id}</td>
					<td>${u.name}</td>
					<td>${u.emailId}</td>
					<td>${u.password}</td>
					<td><a href="user/delete?&id=${u.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<a href="adduser.jsp">Add User</a>
</body>
</html>