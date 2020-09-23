<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Email</title>
</head>
<body>
	<form:form>
		<label for="email">Enter your Email</label>
		<form:input id="email" path="userEmail"/>
	
	</form:form>
</body>
</html>