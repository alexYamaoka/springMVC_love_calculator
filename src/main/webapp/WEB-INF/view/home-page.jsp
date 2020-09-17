<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<!--  
	<script type="text/javascript">

		function validateUsername() {
			var userName = document.getElementById('yourName').value;

			if (userName.length < 1) {
				alert("Your name should be atleast 1 character");
				return false;
			}
			
			return true;
		}
		
	</script>
-->

</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<hr/>
	
	<form:form action="process-homepage" method="get" modelAttribute="userInfoDTO" onSubmit="return validateUsername()">
		<div align="center">
			<p>
				<label for="yourName">Your Name: </label>
				<form:input id="yourName" path="username"/>	
			</p>
			<p>
				<label for="crushName">Crush Name: </label>
				<form:input id="crushName" path="crushName"/>	
			</p>
			<input type="submit" value="calculate"/>
		</div>
	</form:form>
	
</body>
</html>