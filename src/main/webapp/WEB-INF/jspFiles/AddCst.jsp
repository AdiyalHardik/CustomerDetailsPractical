<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Practical | Add Customers</title>
</head>
<body>
	<h2>Add new Customer</h2>
	<form:form method="get" action="/customers/add"
		modelAttribute="metaModel" autocomplete="off">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:input path="gender" type="text" /></td>
			</tr>
			<tr>
				<td>Address 1</td>
				<td><form:input path="add1" type="text" /></td>
			</tr>
			<tr>
				<td>Address 2</td>
				<td><form:input path="add2" type="text" /></td>
			</tr>
			<tr>
				<td>Mobile No.</td>
				<td><form:input path="mobile" type="text" /></td>
			</tr>
			<tr>
				<td>City</td>
				<td><form:input path="city" type="text" /></td>
			</tr>
			<tr>
				<td>ZipCode</td>
				<td><form:input path="zipCode" type="text" /></td>
			</tr>
			<tr>
				<td>State</td>
				<td><form:input path="state" type="text" /></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><form:input path="country" type="text" /></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit"
						value="<c:out value="register" />">Save</button></td>
			</tr>
		</table>
	</form:form>

	<br>
	<a href="/customers/all">View All Customers</a>
</body>
</html>