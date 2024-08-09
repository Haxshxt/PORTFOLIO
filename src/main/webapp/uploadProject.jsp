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
<form action="UploadProject1" method="post" enctype="multipart/form-data">

<input type="file" name="myFile"> <br>
<input type="datetime-local" name="datetime"> <br>
<button>upload</button>

</form>

</body>
</html>