<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Process Email</title>
	<link type="text/css" href="<c:url value='/assets/css/style.css'/>" rel="stylesheet" />
</head>
<body>
	<h1 align="center">Results Sent!</h1>
	<div class="outline">
		<h2>Hi ${userInfoDTO.username} </h2>
		<label>Email successfully sent to ${emailDTO.userEmail} !</label>
	</div>
	
</body>
</html>