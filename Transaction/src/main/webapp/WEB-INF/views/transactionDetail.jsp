<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body style="text-align: center;margin-top: 50px">
	<h3>Statement of all previous transactions</h3>
	<table style="width: 80%; border: 2px solid red;margin-left: 100px;margin-top: 50px" class="table table-hover">
		<tr class="table-primary">
			<td>TransactionID</td>
			<td>Account Number</td>
			<td>Date</td>
			<td>Amount</td>
			<td>Type</td>
			<td>Description</td>
		</tr>

		<c:forEach items="${transactions}" var="tran">
			<tr class="table-warning">
				<td>${tran.transactionId}</td>
				<td>${tran.accountnoben}</td>
				<td>${tran.date}</td>
				<td>${tran.amount}</td>
				<td>${tran.type}</td>
				<td>${tran.description}</td>
			</tr>

		</c:forEach>

	</table>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js "
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj "
		crossorigin="anonymous "></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js "
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN "
		crossorigin="anonymous "></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js "
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV "
		crossorigin="anonymous "></script>
</body>
</html>