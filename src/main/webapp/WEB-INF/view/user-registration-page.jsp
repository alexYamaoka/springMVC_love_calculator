<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<h1 align="center">Please Register Here</h1>
	
	<form:form modelAttribute="userRegistrationDTO">
		<label for="user">User: </label>
		<form:input id="user" path="name"/>
		<br/>
		
		<label for="username">Username: </label>
		<form:input id="username" path="username"/>
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
		</br>
		
		
		<label>Gender: </label>
		Male<form:radiobutton path="gender" value="male"/>
		Female<form:radiobutton path="gender" value="female"/>
		
		
		
		
	</form:form>
	 
	
	
</body>
</html>