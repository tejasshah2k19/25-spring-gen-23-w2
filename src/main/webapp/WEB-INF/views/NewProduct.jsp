<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>New Product</h2>

	<form action="saveproduct" method="post">
		ProductName: <input type="text" name="productName" />
		${result.getFieldError("productName").getDefaultMessage()} <br>
		<br> Price:<input type="text" name="price" />
		${result.getFieldError("price").getDefaultMessage()} <br>
		<br> Qty:<input type="text" name="qty" /><br>
		<br> Tax:<input type="text" name="tax" /><br>
		<br> <input type="submit" value="Save" />

	</form>

</body>
</html>