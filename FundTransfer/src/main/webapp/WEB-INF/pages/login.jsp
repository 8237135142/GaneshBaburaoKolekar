
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
	<h1 style="color: green;" align="center">User Login Page</h1>
	<div align="center">
		<table>
			<frm:form method="POST" modelAttribute="userCmd">

				<%-- 			 <span style='color:red'><frm:errors path="*"/></span><br>  --%>
				<tr>
					<td>UserName:</td>
					<td><frm:input path="uname" /></td>
					<td><span style='color: red'><frm:errors path="uname" /></span></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><frm:input path="pwd" /></td>
					<td><span style='color: red'><frm:errors path="pwd" /></span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login" /></td>
				</tr>
			</frm:form>
		</table>
		<c:if test="${userName ne null}">
			<c:out value="${userName}" />
		</c:if>
		<br>
</body>
</html>