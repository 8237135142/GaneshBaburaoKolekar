
<%@page import="com.transfer.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">


	<h1 style="color: green;" align="center">Home Page</h1>

	<table align="center">
		<tr>
			<th>User Id</th>
			<th>User Name</th>
			<th>Email Id</th>
			<th>Balance</th>
		</tr>
		<tr>
			<td width="60" align="center">${user.id}</td>
			<td width="60" align="center">${user.uname}</td>
			<td width="60" align="center">${user.email}</td>
		</tr>
	</table>
	<br>
	<br>
	<div align="center">
		<a href="account/fundtransfer">FundTransfer &nbsp;&nbsp; </a> <a
			href="transections/txnHistory">Transaction History</a> &nbsp;&nbsp;
	</div>
</body>
</html>