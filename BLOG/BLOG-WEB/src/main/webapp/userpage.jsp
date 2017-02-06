<%@page import="com.aynna.model.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>!!!!Hello Bruh!!!!</title>
	
</head>
<body>
<h1>!!!Hey Mama!!!</h1>
	<!-- 		${ARTICLE_LIST}
			${EXCEPTION_LIST}
 -->
			<br><br><br>
			<c:forEach var="u" items="${ARTICLE_LIST}">
					<h4>${u.title}</h4><br>
					<p>${u.content}</p><br>
					<h10>${u.user.name}</h10>
					<h10>${u.updatedTimestamp}</h10><br><br>
			</c:forEach>

</body>
</html>