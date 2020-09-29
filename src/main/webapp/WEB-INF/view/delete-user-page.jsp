<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete User</title>
	<link type="text/css" href="<c:url value='/assets/css/style.css'/>" rel="stylesheet" />
</head>
<body>
	<h2 align="center">Delete User</h2>
	
	<div class="outline">
		<form action="process-delete-user" method="GET">
		<div align="center">
			
			<label for="username">Username: </label>
			<input id="username" name="username"/>
			
		</div>
		
		<div align="center">
			<input type="submit" value="delete">
		</div>
		

	</form>
	</div>
	
	 
	
</body>
</html>