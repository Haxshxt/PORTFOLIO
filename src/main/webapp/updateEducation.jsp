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

<%
ArrayList<EducationPojo> eduPojoList = (ArrayList<EducationPojo> )session.getAttribute("readEducationArrayList");
String ind = request.getParameter("index");
int index = Integer.parseInt(ind);
EducationPojo eduPojo = eduPojoList.get(index);
%>

<form action="UpdateEducation" method="post">

    SN > <%= eduPojo.getSn() %>
    <input type="hidden" name="sn" value="<%= eduPojo.getSn()%>">
   <input  type="text" name ="year" value="<%= eduPojo.getYear() %>">  <br>
  <input type="text" name="title" value="<%=eduPojo.getTitle()%>"> <br>
  <input  type="text" name="subtitle" value="<%=eduPojo.getSubtitle()%>"> <br>
  <input type="text" name="description" value="<%=eduPojo.getDescription()%>"> <br>
  <button>Update</button>


</form>
</body>
</html>