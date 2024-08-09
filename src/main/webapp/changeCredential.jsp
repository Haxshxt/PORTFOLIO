<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.ReadAdminLoginPojo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

ReadAdminLoginPojo adminLoginData = (ReadAdminLoginPojo) session.getAttribute("adminlogindata");

%>

<form action="ChangeCredential" method="post">




<input type="hidden" name="sn" value="<%=adminLoginData.getSn() %>">
<input type="text" name="username" value="<%=adminLoginData.getUsername() %>">
<input type="password" name="password" value="<%=adminLoginData.getPassword() %>">

<button>change</button>

</form>

</body>
</html>