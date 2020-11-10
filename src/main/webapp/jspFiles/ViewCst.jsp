<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Practical | View Customers</title>
</head>
<body>
	<h1>All Customers</h1>
	<table border="1" width=95%>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Mobile No.</th>
			<th>Address 1</th>
			<th>Address 2</th>
			<th>City</th>
			<th>ZipCode</th>
			<th>State</th>
			<th>Country</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<core:forEach var="li" items="${list}">
			<tr>
				<td>${li.getName()}</td>
				<td>${li.getEmail()}</td>
				<td>${li.getGender()}</td>
				<td>${li.getMobile()}</td>
				<td>${li.getAdd1()}</td>
				<td>${li.getAdd2()}</td>
				<td>${li.getCity()}</td>
				<td>${li.getZipCode()}</td>
				<td>${li.getState()}</td>
				<td>${li.getCountry()}</td>
				<td><a href="/customers/get/${li.getToken()}">Edit</a></td>
				<td><a href="/customers/delete?token=${li.getToken()}">Delete</a></td>
			</tr>

		</core:forEach>
	</table>
	<br>
	<br>
	<a href="/jspFiles/AddCst.jsp">Add New Customer</a>
	<br>
	<br>
	<br>
	<a href="/jspFiles/index.jsp"> <<< Back to Index </a>
</body>
</html>