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

ArrayList<EducationPojo> list = (ArrayList<EducationPojo>)session.getAttribute("readEducationArrayList");
for(int i=0;i<list.size();i++){
	EducationPojo obj = list.get(i);
%>

Sn > <%= obj.getSn() %> <br>
Year > <%= obj.getYear() %><br>
Title > <%= obj.getTitle() %><br>
SubTitle > <%= obj.getSubtitle() %><br>
Description > <%= obj.getDescription() %><br>
DateTime > <%= obj.getDatetime() %><br>

<form action="updateEducation.jsp" method="post">
<input type="hidden" name="index" value="<%=i%>">
<button>Update</button>
</form>
<form action="DeleteEducation" method="post" >
<input type="hidden" name ="sn" value="<%=obj.getSn()%>">
<button>Delete</button>
</form>


 <a href="ReadEducation"> Refresh</a>
<h5>---------------------------------------</h5>
<br>

<%

}
%>

</body>
</html>