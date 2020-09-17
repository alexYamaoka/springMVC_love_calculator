<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<h1 align="center">Please Register Here</h1>
	
	<form:form modelAttribute="userRegistrationDTO">
		<label for="user">User: </label>
		<form:input id="user" path="name"/>
		<br/>
		<label for="username">Username: </label>
		<form:input id="username" path="username"/>
		<br/>
		<label for="password">Password: </label>
		<form:password id="passwprd" path="password"/>
		<br/>
		<label>Country Name: </label>
		<form:select path="country">
			<form:option value="U.S" label="U.S"></form:option>
			<form:option value="Japan" label="Japan"></form:option>
		</form:select>
		
	</form:form>
	 
	
	
</body>
</html>