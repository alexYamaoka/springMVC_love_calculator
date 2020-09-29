<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
	<link type="text/css" href="<c:url value='/assets/css/style.css'/>" rel="stylesheet" />
</head>
<body>
	<div align="center">
		<h1>Login</h1>
		<div class="outline">
			<p align="left">
				<a href="/spring-love-calculator/register">Don't have an account? Register</a>
			</p>
			
			<form action="process-login" method="GET">
				<div align="center">
					
					<label for="username">Username: </label>
					<input id="username" name="username"/>
					<br/><br/>
					
					<label for="password">Password: </label>
					<input type="password" id="password" name="password"/>
					<br/><br/>
					
				</div>
				
				<div align="center">
					<input type="submit" value="login">
				</div>

			</form>
		</div>
	</div>
	
	
	
	
	
</body>
</html>