<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results</title>
	<link type="text/css" href="<c:url value='/assets/css/style.css'/>" rel="stylesheet" />
</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<hr/>
	
	
	
	<div align="center" class="outline">
		
		<h2>The Love Calculator Predicts...</h2>
		${userInfoDTO.username} and ${userInfoDTO.crushName} are <br/>
		${userInfoDTO.result}!
		<br/><br/>
		
		
		<a href="/spring-love-calculator/sendEmail">Send results to your Email</a>
		<br/><br/>
		<a href="/spring-love-calculator/">Calculate Another Match</a>
		
	</div>
	
</body>
</html>