<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
	<link type="text/css" href="<c:url value='/assets/css/style.css'/>" rel="stylesheet" />
</head>
<body>
	<h1 align="center">Billing</h1>
	
	<div class="outline" align="center">
		<form:form action="process-payment" method="get" modelAttribute="billDTO">
		
			<label for="creditCard">Card Number: </label>
			<form:input  id="creditCard" path="creditCard"/>
			<br/><br/>
	
			<label for="billingAmount">Amount</label>
			<form:input id="billingAmount" path="amount" />
			<br/><br/>
		
			<label for="currency">Currency</label>
			<form:input id="currency" path="currency"/>
			<br/><br/>
		
			<label for="date">Date</label>
			<form:input id="date" path="date"/>
			<br/><br/>
	
		<div align="center">
				<input type="submit" value="Pay Bill">
		</div>
	</form:form>
	</div>
	

</body>
</html>