<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Email</title>
</head>
<body>

	<h1>Hi ${userInfoDTO.username} </h1>
	<h2>Send Results to Your Email</h2>

	<form:form action="process-email" method="GET" modelAttribute="emailDTO">
		<label for="email">Enter your Email</label>
		<form:input id="email" path="userEmail"/>
		
		<input type="submit" value="send" />
	</form:form>
</body>
</html>

