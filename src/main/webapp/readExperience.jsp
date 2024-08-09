<%@page import="model.ExperiencePojo"%>
<%@page import="model.EducationPojo"%>
<%@page import="java.util.ArrayList"%>
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
<%
ArrayList<ExperiencePojo> list = (ArrayList<ExperiencePojo> ) session.getAttribute("readExperienceArrayList");
int index=0;
for(ExperiencePojo obj : list){
	
%>

SN >  <%= obj.getSn()%> <br>
Year > <%= obj.getYear() %> <br>
Title > <%= obj.getTitle()%> <br>
Subtitle > <%= obj.getSubtitle() %> <br>
Description > <%=obj.getDescription() %> <br>

<br>
<form action="updateExperience.jsp">
<input type="hidden" name="index" value="<%=index%>">
<button>Update</button>
</form>

<form action="DeleteExperience" method="post">
<input type="hidden" name="sn" value="<%= obj.getSn()%>">
<button>Delete</button>
</form>


<% 
index=index+1;
} %>


</body>
</html>