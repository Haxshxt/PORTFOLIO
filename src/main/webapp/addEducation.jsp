<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="msg.jsp" %>
	
	<form action="UploadEducation" method="post">
		<input name="year" placeholder="year" type="text">  <br>
		<input name="title" placeholder="title" type="text"> <br>
		<input name="subtitle" placeholder="sub-title" type="text"> <br>
		<input name="description" placeholder="description" type="text"> <br>
		
		<button>Add</button>
	</form>
	
</body>
</html>