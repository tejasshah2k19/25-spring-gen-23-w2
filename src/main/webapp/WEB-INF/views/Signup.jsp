<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
</head>
<body>
<h2>Signup</h2>

<form action="saveuser" method="post" enctype="multipart/form-data">
	FirstName: <input type="text" name="firstName"/><br><br>
	LastName:<input type="text" name="lastName"/><br><br>
	Email:<input type="text" name="email"/><br><br>
	Password: <input type="text" name="password"/><br><br>
	ProfilePic : <input type="file" name="profilePic"/><br><Br>
	
		<input type="Submit" value="Signup"/>
</form>

<a href="login">Login</a>

</body>
</html>