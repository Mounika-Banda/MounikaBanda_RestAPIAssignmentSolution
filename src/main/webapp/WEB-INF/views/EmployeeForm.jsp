<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="save" method="post">
		<table>
			<tr>
				<td>FirstName</td>
				<td><input type="text" value="${employee.firstname}"
					name="firstname" /></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><input type="text" value="${employee.lastname}"
					name="lastname" /></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" value="${employee.email}" name="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden"
					value='${employee.employeeid}' name="id" /><input type="submit" /></td>
			</tr>
		</table>

	</form>
</body>
</html>