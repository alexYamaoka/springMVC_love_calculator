<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view all users</title>
</head>
<body>
	<h1 align="center">Registered Users</h1>
	<table border="1" cellpadding="30%" align="center">
		<tr>
			<th>username</th>
			<th>password</th>
			<th>country</th>
			<th>hobbies</th>
			<th>gender</th>
			<th>age</th>
			<th>email</th>
			<th>phone</th>
			
			
		</tr>
		<c:forEach var="user" items="${usersList}">
			<tr>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>${user.country}</td>
				<td>${user.hobbies}</td>
				<td>${user.gender}</td>
				<td>${user.age}</td>
				<td>${user.communicationDTO.email}</td>
				<td>${user.communicationDTO.phone}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>