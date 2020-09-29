<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view all users</title>

	<link type="text/css" href="<c:url value='/assets/css/style.css'/>" rel="stylesheet" />
</head>
<body>
	<h1 align="center">Registered Users</h1>
	
	<div class="outline">
		<table class="table">   <!--  border="1" cellpadding="30%" align="center"-->
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Country</th>
			<th>Hobbies</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Email</th>
			<th>Phone</th>
			
			
		</tr>
		<c:forEach var="user" items="${usersList}">
			<tr>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>${user.country}</td>
				
				<td>
					<c:forEach var="temp" items="${user.hobbies}">
						${temp}
					</c:forEach>
				</td>
				
				
				<td>${user.gender}</td>
				<td>${user.age}</td>
				<td>${user.communicationDTO.email}</td>
				<td>${user.communicationDTO.phone}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br/><br/>
	<div align="center">
		<a href="/spring-love-calculator/">Calculate Love</a>
		&nbsp &nbsp
		<a href="/spring-love-calculator/register">Register User</a>
		&nbsp &nbsp
		<a href="/spring-love-calculator/delete-user">Delete User</a>
	</div>
	
	
	
	
	</div>
	
</body>
</html>