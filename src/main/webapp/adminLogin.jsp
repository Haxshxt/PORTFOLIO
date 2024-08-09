<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="msg.jsp" %>
<form action="AdminLogin" method="post">

	<input type="text" name="username" placeholder="enter-username"> <br>
	<input type="password" name="password" placeholder="enter-password"> <br>
	<button>login</button>

</form>

</body>
</html>