<%@page import="model.ExperiencePojo"%>
<%@page import="dao.ExperienceDaoImpl"%>
<%@page import="dao.ExperienceDao"%>
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

<%
ArrayList<ExperiencePojo> list = (ArrayList<ExperiencePojo>  ) session.getAttribute("readExperienceArrayList");
String ind = request.getParameter("index");
int index = Integer.parseInt(ind);
ExperiencePojo obj = list.get(index);

	
%>

<form action="UpdateExperience" method="post">
<input type="hidden" name="sn" value="<%= obj.getSn()%>">
 <input type="text" name="year" value="<%= obj.getYear() %>"> <br>
  <input type="text" name="title" value="<%= obj.getTitle() %>"> <br>
   <input type="text" name="subtitle" value="<%=obj.getSubtitle()%>"> <br>
    <input type="text" name="description" value="<%=obj.getDescription()%>"> <br>
    
    <button>Update</button>
</form>
<%

%>
</body>
</html>