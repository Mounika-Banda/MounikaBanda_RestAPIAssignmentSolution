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
	<%-- Show Add Student and Logout Hyperlinks --%>
	<table>
		<tr>
			<td><a href="students/addStudent">Add a new Book</a></td>
			<td><a href="/Lab6/logout">Logout</a></td>
		</tr>
	</table>
	<form action="students/search" method="post">
		<table>
			<tr>
				<td>FirstName</td>
				<td><input type="text" name="firstname" /></td>
			</tr>
			<tr>
				<td>Course</td>
				<td><input type="text" name="course" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" /></td>
			</tr>
		</table>
	</form>

	<%-- Table to show Student details --%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Course</th>
			<th>Country</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${students}" var="b">
			<tr>
				<td>${b.studentid}</td>
				<td>${b.firstname}</td>
				<td>${b.lastname}</td>
				<td>${b.course}</td>
				<td>${b.country}</td>
				<td><a href="updateStudent?id=${b.studentid}">Update</a><a
					href="deleteStudent?id=${b.studentid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>