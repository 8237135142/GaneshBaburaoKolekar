
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
	<h1 style="color: green;" align="center">Transection Details Page</h1>
	<div align="center"></div>
	<table class="table table-bordered" style="width: 300px" align="center">
		<tr>
			<th>AccID</th>
			<th>AccNo</th>
			<th>AccName</th>
			<th>Balance</th>
			<th>Txn Date</th>
		</tr>
		<c:forEach items="${txnList}" var="txn">
			<tr>
				<td width="60" align="center">${txn.id}</td>
				<td width="60" align="center">${txn.AccNo}</td>
				<td width="60" align="center">${txn.name}</td>
				<td width="60" align="center">${txn.balance}</td>
				<td width="60" align="center">${txn.date}</td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>