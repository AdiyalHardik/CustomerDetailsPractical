<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Practical | Edit Customer</title>
</head>
<body>

	<form:form method="post" action="/customers/update"
		modelAttribute="metaModel" autocomplete="off">
		<form:input path="token" type="hidden" />
		<table style="margin-top: 5%">
			<tr>
				<td>Name:</td>
				<td><form:input type="text" path="name"
						placeholder="Enter name" required="required" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input type="text" path="email"
						placeholder="Enter Email" required="required" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><form:radiobutton path="gender" value="male" />Male<form:radiobutton
						path="gender" value="female" />Female</td>
			</tr>
			<tr>
				<td>Address 1:</td>
				<td><form:textarea rows="2" cols="10" path="add1"></form:textarea></td>
			</tr>
			<tr>
				<td>Address 2:</td>
				<td><form:textarea rows="2" cols="10" path="add2"></form:textarea></td>
			</tr>
			<tr>
				<td>Mobile Number:</td>
				<td><form:input type="tel" path="mobile"
						placeholder="Enter 10 digit Number" required="required"
						pattern="^\d{10}$" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input type="text" path="city"
						placeholder="Enter City" required="required" /></td>
			</tr>
			<tr>
				<td>ZipCode:</td>
				<td><form:input type="tel" path="zipCode" pattern="^\d{6}$"
						placeholder="Enter 6 digit ZipCode" required="required" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><form:input type="text" path="state"
						placeholder="Enter State" required="required" /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><form:select path="country" required="required">
						<option>${metaModel.getCountry()}</option>
						<option>India</option>
						<option>U.S.</option>
						<option>U.K.</option>
						<option>U.A.E.</option>
						<option>Paris</option>
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="Add"
					style="margin-left: 50%"></td>
			</tr>
		</table>
	</form:form>

	<br>
	<br>
	<br>
	<a href="/jspFiles/index.jsp"> <<< Back to Index </a>

</body>
</html>