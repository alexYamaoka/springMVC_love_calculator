<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
</head>
<body>
	<h1 align="center">This is the payment page</h1>
	
	<form:form action="process-payment" method="get" modelAttribute="billDTO">
		<div align="center">
			<h2>Billing</h2>
			<p>
				<label for="creditCard">Card Number: </label>
				<form:input  id="creditCard" path="creditCard"/>
			</p>	
			<p>
				<label for="billingAmount">Amount</label>
				<form:input id="billingAmount" path="amount" />
			</p>
			<p>
				<label for="currency">Currency</label>
				<form:input id="currency" path="currency"/>
			</p>
			<p>
				<label for="date">Date</label>
				<form:input id="date" path="date"/>
			</p>
		</div>
		
		<div align="center">
				<input type="submit" value="Pay Bill">
		</div>
	</form:form>
	
	
	
</body>
</html>