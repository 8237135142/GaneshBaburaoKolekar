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
	<h4>Transfer Money To Bank Account</h4>
	<form:form modelAttribute="transfer" action="showtransfer/transfer"
		method="POST">
		<table style="width: 50%" align="center" class=table>
			<tr>
				<td>Your Account Number</td>
				<td><form:input path="accountNo" /></td>
				<td><form:errors path="accountNo" style="color:red;"
						cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Beneficiary Acccount Number</td>
				<td><form:input path="accountnoben" /></td>
				<td><form:errors path="accountnoben" style="color:red;"
						cssClass="error"></form:errors>
				<td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><form:input path="amountBig" /></td>
				<td><form:errors path="amountBig" style="color:red;"
						cssClass="error"></form:errors></td>
				<td><c:if test="${not empty zero}">
						<div class="alert alert-danger">
							<p>${zero}</p>
						</div>
					</c:if></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" style="color:red;"
						cssClass="error"></form:errors></td>
			</tr>
		</table>
		<input type="hidden" name="userid" value="${userid}" />
		<input type="Submit" value="Transfer" onclick="window.confirm(" Do you
			want to proceed with transaction?")"/>&nbsp;&nbsp;&nbsp;
	<input type="Reset" value="Reset" />
		<c:if test="${not empty error}">
			<div class="alert alert-danger">
				<p>the amount entered for transaction is more than the account
					balance. so, please enter the amount less than the account balance.
				</p>
			</div>
		</c:if>
		<c:if test="${not empty check}">
			<div class="alert alert-danger">
				<p>${check}</p>
			</div>
		</c:if>
	</form:form>
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