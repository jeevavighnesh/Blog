<%@page import="com.aynna.model.User"%>
<%@page import="com.aynna.model.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>!!!!Hello Bruh!!!!</title>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
 <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	  <link rel="stylesheet" href="materialize.min.css">
	  <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<header>
	<!-- Dropdown Structure -->
	<ul id="dropdown1" class="dropdown-content">
		<li><a href="#!">one</a></li>
		<li><a href="#!">two</a></li>
		<li class="divider"></li>
		<li><a href="#!">three</a></li>
	</ul>
	<nav>
		<div class="nav-wrapper">
		<div class="row">
			<div class="col">
			<a href="/user" class="brand-logo">_BLOG</a>
		</div>
			<!-- activate side-bav in mobile view -->
			<a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
			<ul class="right hide-on-med-and-down">
				<li><a href="../">Log Out</a></li>
				<!-- Dropdown Trigger -->
				<li><a class="dropdown-button" href="#!" data-activates="dropdown1">Dropdown<i class="material-icons right">arrow_drop_down</i></a></li>
			</ul>
			<!-- navbar for mobile -->
			<ul class="side-nav" id="mobile-demo">
				<li><a href="#">${username}</a></li>
				<li><a href="components.html">Components</a></li>
			</ul>
			</div>
		</div>
	</nav>
</header>
<h1>!!!Hey Mama!!!</h1>
<h3>This is Whats goig on in our blog</h3>
	<!-- 		${ARTICLE_LIST}
			${EXCEPTION_LIST}
 -->
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

			<a href="/../post_article.html">Post Article</a>

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