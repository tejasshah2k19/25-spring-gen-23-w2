<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>List User</h2>

<a href="signup">New User</a>
<br>
	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.userId}</td>
				<td>${u.firstName}</td>
				<td>${u.email}</td>
				<td><a href="deleteuser?userId=${u.userId}">Delete</a> | <a href="viewuser?userId=${u.userId}">View</a>|
				<a href="edituser?userId=${u.userId}">Edit</a>
				 </td>
				
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>