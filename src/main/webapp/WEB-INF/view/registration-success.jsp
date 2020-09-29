<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Success</title>
	<link type="text/css" href="<c:url value='/assets/css/style.css'/>" rel="stylesheet" />
</head>
<body>
	<h1 align="center">Your Registration Is Successful</h1>
	
	<div class="outline">
		<h2>The details entered by you are: </h2>
		User: 		${userRegistrationDTO.name}<br/>
		Username:   ${userRegistrationDTO.username}<br/>
		Password:   ${userRegistrationDTO.password}<br/>
		Country:    ${userRegistrationDTO.country}<br/>
		Hobbies:    
			<c:forEach var="temp" items="${userRegistrationDTO.hobbies}">
				${temp}
			</c:forEach>
			<br/>
		Gender:     ${userRegistrationDTO.gender}<br/>
		Age: 		${userRegistrationDTO.age}<br/>
		Email: 		${userRegistrationDTO.communicationDTO.email} <br/>
		Phone: 		${userRegistrationDTO.communicationDTO.phone}<br/>
		
		<br/><br/>
		<a href="/spring-love-calculator/"> <p align="center">Calculate Love</p></a>
	</div>
	
	
</body>
</html>