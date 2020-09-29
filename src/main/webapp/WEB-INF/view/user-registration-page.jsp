<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
	<link type="text/css" href="<c:url value='/assets/css/style.css'/>" rel="stylesheet" />
</head>
<body>
	<h1 align="center">Please Register Here</h1>
	
	<div class="outline">
		<p align="left">
			<a href="/spring-love-calculator/login">Already have an account? Login</a>
		</p>
			
		<form:form action="registration-success" method="GET" modelAttribute="userRegistrationDTO">
		<div align="center">
			<label for="name">User: </label>
			<form:input id="name" path="name"/>
			<form:errors path="name" cssClass="error" />
			<br/>
			
			<label for="username">Username: </label>
			<form:input id="username" path="username"/>
			<form:errors path="username" cssClass="error" />
			<br/>
			
			<label for="password">Password: </label>
			<form:password id="passwprd" path="password"/>
			<br/>
			
			<label for="country">Country Name: </label>
			<form:select id="country" path="country">
				<form:option value="U.S" label="U.S"></form:option>
				<form:option value="Mexico" label="Mexico"></form:option>
				<form:option value="Japan" label="Japan"></form:option>
				<form:option value="Canada" label="Canada"></form:option>
				<form:option value="Spain" label="Spain"></form:option>
				<form:option value="Germany" label="Germany"></form:option>
				<form:option value="France" label="France"></form:option>
			</form:select>
			<br/>
			
			<label>Hobbies: </label>
			Baseball<form:checkbox path="hobbies" value="baseball"/>
			Soccer<form:checkbox path="hobbies" value="soccer"/>
			Surfing<form:checkbox path="hobbies" value="surfing"/>
			Camping<form:checkbox path="hobbies" value="camping"/>
			Travel<form:checkbox path="hobbies" value="travel"/>
			<br/>
			
			<label>Gender: </label>
			Male<form:radiobutton path="gender" value="male"/>
			Female<form:radiobutton path="gender" value="female"/>
			<br/>
			
			<label for="age">Age: </label>
			<form:input id="age" path="age"/>
			<form:errors path="age" cssClass="error"/>
		</div>
		
		<div align="center">
			<h2>Communication:</h2>
			
			<label for="email">Email</label>
			<form:input id="email" path="communicationDTO.email"/>
			<form:errors path="communicationDTO.email" cssClass="error"/>
			<br/>
			
			<label for="phone">Phone</label>
			<form:input id="phone" path="communicationDTO.phone"/>
		</div>
		
		<div align="center">
			<input type="submit" value="register">
		</div>
		

	</form:form>
	
	</div>
	
	 
	
	
</body>
</html>