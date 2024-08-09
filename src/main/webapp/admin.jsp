<%
String adminLogin = (String)session.getAttribute("adminlogin");
if(adminLogin==null){
	response.sendRedirect("adminLogin.jsp");
	return;
}

%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="ReadContact"> Read Contact Messages </a> <br><br>
<br>-------------------------------- <br>
<a href="uploadProject.jsp">Upload File </a> <br>
<a href="readProjects.jsp"> Read uploaded files </a> <br> <br> 
<br>--------------------------------<br>
<a href="addEducation.jsp">ADD Education </a><br> <br> 
<a href="ReadEducation"> Read Education </a><br><br>

<br>--------------------------------<br>

<a href ="addExperiences.jsp"> Add Experiences</a> <br>
<a href="ReadExperience">Read Experiences</a> <br><br>

<br>--------------------------------<br>

<a href="uploadResume.jsp">Upload Resume</a>
<form action="Logout" method="post">
    <button type="submit">Logout</button>
</form>

<form action="ReadAdminLogin" method="post">
<button>Change Credential</button>
</form>

</body>
</html>