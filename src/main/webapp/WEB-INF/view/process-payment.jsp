<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Process Payment</title>
	<link type="text/css" href="<c:url value='/assets/css/style.css'/>" rel="stylesheet" />
</head>
<body>
	<h1 align="center">Processing Payment</h1>
	<div class="outline" align="center">
		Credit Card: ${billDTO.creditCard}<br/><br/>
		Amount: 	 ${billDTO.currency.symbol} ${billDTO.amount}<br/><br/>
		Currency: 	 ${billDTO.currency.displayName}<br/><br/>
		Date: 		 ${billDTO.date}<br/><br/>
	
	</div>
</body>
</html>