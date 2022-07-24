<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- Show Add Employee and Logout Hyperlinks --%>
	<table>
		<tr>
			<td><a href="employees/addEmployee">Add a new Employee</a></td>
			<td><a href="/GradedAssignment_EmployeeMgmt/logout">Logout</a></td>
		</tr>
	</table>
	<form action="employees/search" method="post">
		<table>
			<tr>
				<td>FirstName</td>
				<td><input type="text" name="firstname" /></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><input type="text" name="lastname" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" /></td>
			</tr>
		</table>
	</form>

	<%-- Table to show Employee details --%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${employees}" var="b">
			<tr>
				<td>${b.employeeid}</td>
				<td>${b.firstname}</td>
				<td>${b.lastname}</td>
				<td>${b.email}</td>
				<td><a href="updateEmployee?id=${b.employeeid}">Update</a><a
					href="deleteEmployee?id=${b.employeeid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>