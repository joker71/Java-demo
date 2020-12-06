<%@page import="SimpleLove.beans.USER_ACCOUNT"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="servlogin" method="post">
Username : <input type="text" name="parusername"><br>
Password: <input type="password" name="parpass"><br>
<input type="submit" value="Submit" name="login">
</form>

</body>
</html>