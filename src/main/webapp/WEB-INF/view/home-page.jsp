<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

	
	<script type="text/javascript">
		function validateUsername() {
			var username = document.getElementById('yourName').value;
			var crushName = document.getElementById('crushName').value;
	
			if (username.length < 3) {
				alert("Your name should be atleast 3 character");
				return false;
			}
			if (crushName.length < 3) {
				alert("Crush name should be atleast 3 character");
				return false;
			}
			return true;
		}
	</script>
	
	<link type="text/css" href="<c:url value='/assets/css/style.css'/>" rel="stylesheet" />
	
	

</head>
<body>
	<div class="background">
		<h1 align="center">Love Calculator</h1>
		<hr/>
		
		<form:form action="process-homepage" method="get" modelAttribute="userInfoDTO" class="outline"> <!--onSubmit="return validateUsername()" -->
			<div align="center">
				<p>
					<label for="yourName">Your Name: </label>
					<form:input id="yourName" path="username"/>	
					<form:errors path="username" cssClass="error"/>
				</p>
				<p>
					<label for="crushName">Crush Name: </label>
					<form:input id="crushName" path="crushName"/>	
					<form:errors path="crushName" cssClass="error"/>
				</p>
				<p>
					<form:checkbox id="check" path="agreedToTermsAndCondition"/>
					<label for="check">I am agreeing that this is for fun</label>
					<form:errors path="agreedToTermsAndCondition" cssClass="error"/>
				</p>
				<input type="submit" value="calculate"/>
			</div>
		</form:form>
	
	
	</div>
	
	
	
	
	
	
</body>
</html>