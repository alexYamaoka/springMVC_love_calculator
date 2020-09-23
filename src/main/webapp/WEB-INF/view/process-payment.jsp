<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Process Payment</title>
</head>
<body>
	<h1>Processing Payment Page</h1>
	Credit Card: ${billDTO.creditCard}<br/>
	Amount: 	 ${billDTO.amount}<br/>
	Currency: 	 ${billDTO.currency}<br/>
	Date: 		 ${billDTO.date}<br/>
	
	
	
</body>
</html>