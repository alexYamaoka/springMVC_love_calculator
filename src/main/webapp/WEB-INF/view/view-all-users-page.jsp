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
		<c:forEach var="user" items="${usersMap}">
			<tr>
				<td>${user.value.username}</td>
				<td>${user.value.password}</td>
				<td>${user.value.country}</td>
				
				<td>
					<c:forEach var="temp" items="${user.value.hobbies}">
						${temp}
					</c:forEach>
				</td>
				
				
				<td>${user.value.gender}</td>
				<td>${user.value.age}</td>
				<td>${user.value.communicationDTO.email}</td>
				<td>${user.value.communicationDTO.phone}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br/><br/>
	<div align="center">
		<a href="/spring-love-calculator/register">Register User</a>
		&nbsp &nbsp
		<a href="/spring-love-calculator/delete-user">Delete User</a>
	</div>
	
	
	
	
	</div>
	
</body>
</html>