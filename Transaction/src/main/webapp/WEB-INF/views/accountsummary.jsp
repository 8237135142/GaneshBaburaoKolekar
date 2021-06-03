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
<body style="text-align: center;">
	<div class="container">
		<h3 style="margin-top: 50px;">Account Details</h3>

		<table style="width: 80%; border: 2px solid red;margin-left: 150px" class="table table-hover">
			<tr class="table-primary">
				<td>AccountID</td>
				<td>Name</td>
				<td>Account Number</td>
				<td>UserID</td>
				<td>Email</td>
				<td>Account Balance</td>
			</tr>

			<tr class="table-warning">
				<td>${account.accountId}</td>
				<td>${user.username}</td>
				<td>${account.accountNo}</td>
				<td>${account.userId}</td>
				<td>${user.email}</td>
				<td>${account.balance}</td>
			</tr>

		</table>
		<hr>
		<a href="showtransfer/${account.userId}">Make Transfer</a> <span
			style="white-space: normal;"></span> <a
			href="statement/${account.userId}">Show Statement</a>
	</div>
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