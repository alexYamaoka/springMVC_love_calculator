<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
	<link type="text/css" href="<c:url value='/assets/css/style.css'/>" rel="stylesheet" />
</head>
<body>
	<h1>Admin</h1>
	
	<div class="outline" align="center">
		<a href="/spring-love-calculator/view-all">View All Registered Users</a>
		&nbsp &nbsp
		<a href="/spring-love-calculator/register">Register User</a>
		&nbsp &nbsp
		<a href="/spring-love-calculator/delete-user">Delete User</a>
	</div>
</body>
</html>