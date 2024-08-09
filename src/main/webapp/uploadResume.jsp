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
<form action="UploadResume" method="post" enctype="multipart/form-data"> <br><br>
<input type="file" name ="resume"><br><br>
<button>upload</button>
</form>
</body>
</html>