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
	
	<form:form action="process-payment" method="get" modelAttribute="billing">
		<div align="center">
			<h2>Billing</h2>
			<p>
				<label for="cardNumber">Card Number: </label>
				<form:input  id="cardNumber" path="creditCard"/>
			</p>	
			<p>
				<label for="billingAmount">Amount</label>
				<form:input id="billingAmount" path="paymentAmount" />
			</p>
			<p>
				<label>Currency</label>
			</p>
			<p>
				<label>Date</label>
			</p>
		</div>
		
		<div align="center">
				<input type="submit" value="Pay Bill">
		</div>
	</form:form>
	
	
	
</body>
</html>