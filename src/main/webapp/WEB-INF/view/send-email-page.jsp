<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Email</title>
	<link type="text/css" href="<c:url value='/assets/css/style.css'/>" rel="stylesheet" />
</head>
<body>
	
	<h1 align="center">Send Results</h1>
	
	<div class="outline" align="center">
		<h2>Hi ${userInfoDTO.username} </h2>
		
	
		<form:form action="process-email" method="GET" modelAttribute="emailDTO">
			<label for="email">Enter your Email</label>
			<form:input id="email" path="userEmail"/>
			
			<input type="submit" value="send" />
		</form:form>
	</div>
	
</body>
</html>

