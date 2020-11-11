<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Practical | Products</title>
</head>
<body>
	<h1>All Products</h1>
	<table border="1" width=95%>
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Vendor</th>
			<th>Product Type</th>
			<th>Published Scope</th>
		</tr>
		<core:forEach var="li" items="${list}">
			<tr>
				<td>${li.getId()}</td>
				<td>${li.getTitle()}</td>
				<td>${li.getVendor()}</td>
				<td>${li.getProduct_type()}</td>
				<td>${li.getPublished_scope()}</td>
			</tr>
		</core:forEach>
	</table>
	<br>
	<br>
	<a href="/product/insert">Add New Products</a>
	<br>
	<br>
	<br>
	<a href="/jspFiles/index.jsp"> <<< Back to Index </a>
</body>
</html>