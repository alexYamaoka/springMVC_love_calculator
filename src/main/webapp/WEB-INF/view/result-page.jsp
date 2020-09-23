<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results</title>
</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<hr/>
	
	
	
	<div align="center">
		
		<h2>The Love Calculator Predicts...</h2>
		${userInfoDTO.username} and ${userInfoDTO.crushName} are <br/>
		FRIENDS!
		<br/><br/>
		
		
		<a href="/spring-love-calculator/sendEmail">Send results to your Email</a>
	</div>
	
</body>
</html>