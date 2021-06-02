
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">

	<h1 style="color: green;" align="center">Fund Transfer Page</h1>
	<div align="center">

		<form action="fundtransfer" method="POST">
			<table>
				<tr>
					<td>From Account:</td>
					<td><input type="text" name="sourceAccNo" /></td>
				</tr>
				<tr>
					<td>To Account:</td>
					<td><input type="text" name="dedestAccNo" /></td>
				</tr>
				<tr>
					<td>Amount:</td>
					<td><input type="text" name="amount" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>