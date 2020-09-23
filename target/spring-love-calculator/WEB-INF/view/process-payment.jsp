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
	<div align="center">
		<h1>Processing Payment Page</h1>
		Credit Card: ${billDTO.creditCard}<br/>
		Amount: 	 ${billDTO.currency.symbol} ${billDTO.amount}<br/>
		Currency: 	 ${billDTO.currency.displayName}<br/>
		Date: 		 ${billDTO.date}<br/>
	
	</div>
</body>
</html>