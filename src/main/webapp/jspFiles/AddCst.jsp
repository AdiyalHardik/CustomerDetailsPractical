<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Practical | User Add form</title>
</head>
<body>
	<form action="/customers/add" method="post" autocomplete="off"
		name="form">
		<table style="margin-top: 5%">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" placeholder="Enter name"
					required="required"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" placeholder="Enter Email"
					required="required"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="male">Male<input
					type="radio" name="sex" value="female">Female</td>
			</tr>
			<tr>
				<td>Address 1:</td>
				<td><textarea rows="2" cols="10" name="add1"></textarea></td>
			</tr>
			<tr>
				<td>Address 2:</td>
				<td><textarea rows=2 cols="10" name="add2"></textarea></td>
			</tr>
			<tr>
				<td>Mobile Number:</td>
				<td><input type="number" name="mobile"
					placeholder="Enter Mobile Number" required="required"></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city" placeholder="Enter City"
					required="required"></td>
			</tr>
			<tr>
				<td>ZipCode:</td>
				<td><input type="number" name="zipCode"
					placeholder="Enter ZipCode" required="required"></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="state" placeholder="Enter State"
					required="required"></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><select name="country">
						<option>--Select Country--</option>
						<option>India</option>
						<option>U.S.</option>
						<option>U.K.</option>
						<option>U.A.E.</option>
						<option>Paris</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="Add"
					style="margin-left: 50%"></td>
			</tr>
		</table>
	</form>

	<br>
	<br>
	<br>
	<a href="/customers/all"> << Back</a>
	<br>
	<br>
	<br>
	<a href="/jspFiles/index.jsp"><<< Back to Index </a>
</body>
</html>