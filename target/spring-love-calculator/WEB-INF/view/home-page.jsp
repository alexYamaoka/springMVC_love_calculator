<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<hr/>
	
	<form action="process-homepage" method="get">
		<div align="center">
			<p>
				<label for="yourName">Your Name: </label>
				<input type="text" id="yourName" name="username"/>	
			</p>
			<p>
				<label for="crushName">Crush Name: </label>
				<input type="text" id="crushName" name="crushName"/>	
			</p>
			<input type="submit" value="calculate"/>
		</div>
	</form>
	
	
	
	
	
	
</body>
</html>