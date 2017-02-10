<%@page import="com.aynna.exception.ServiceException"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="utf-8">
	<title>Log In</title>
	 <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	  <link rel="stylesheet" href="materialize.min.css">
	  <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>

<body>
<header>
	
	<nav>
	    <div class="row">
			    <div class = "centre">
				    <div class="nav-wrapper"><a href="/" class="brand-logo">_BLOG</a></div>
			    </div>
			    	
			    <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
	    </div>
	</nav>
	
</header><br><br>
<div class="row">
	<div class="container">
		<form action="/home/login" method="POST">
     		<div class="col s3">
            	<div class="input-field">
           			<input id="email" type="email" name="EmailId" class="validate">
            		<label for="email" data-error="wrong" data-success="right">Email</label>
	        	</div>
	        	</div>
			<div class="col s3">
				<div class="input-field">
			    	<input id="password" type="password" name="Password" class="validate">
	          		<label for="password">Password</label>
			  		</div>
	  		</div>
			<div class="col s3"><button class="btn waves-effect waves-light" type="submit" name="action">Log In</button>
			</div>
	    	<div class="col s3"><button type="button" class="btn waves-effect waves-light" onclick="window.location.href='register.jsp'"><i class="mdi-content-send right"></i>Sign Up</button>
	    		</div>
	  	</form>
	</div>
	<div><span style="color:red">${EXCEPTIONS}</span></div>
</div>

<h1>Welcome</h1>
<h4>This is Whats going on in our blog</h4>
			<br>
			<c:forEach var="u" items="${ARTICLE_LIST}">
				<div class="container">
					<div class="row">
						<div class="col l8">
							<div class="card-panel cyan">

								<h3>${u.title}</h3>
								<p>${u.content}</p><br>
								<div class="container">
								<h10>${u.user.name}</h10>
								<h10>Last updated on ${u.updatedTimestamp}</h10></div>

							</div>
						</div>
					</div>
				</div>
					<br><br>
			</c:forEach>

</body>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           

  <!-- Compiled and minified JavaScript -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>

<script>
	
	$( document ).ready(function(){

		$(".button-collapse").sideNav();
		
	});

</script>

</html>
