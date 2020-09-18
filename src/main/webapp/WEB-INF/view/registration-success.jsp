<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Success</title>
</head>
<body>
	<h1>Your Registration Is Successful</h1>
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
	Email: 		${userRegistrationDTO.communicationDTO.email} <br/>
	Phone: 		${userRegistrationDTO.phone}<br/>
	
</body>
</html>