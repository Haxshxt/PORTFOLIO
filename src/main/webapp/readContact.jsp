<%
String adminLogin = (String)session.getAttribute("adminlogin");
if(adminLogin==null){
	response.sendRedirect("adminLogin.jsp");
	return;
}

%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ReadContactPojo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="msg.jsp" %>
<%

	ArrayList<ReadContactPojo> arrayList =  (ArrayList<ReadContactPojo>)session.getAttribute("readcontact");
	
		for(ReadContactPojo readContactPojo : arrayList ){
			
		
%>

		SN > <%= readContactPojo.getSn() %> <br>
		NAME > <%= readContactPojo.getName() %><br>
		EMAIL > <%= readContactPojo.getEmail() %> <br>
		MESSAGE > <%= readContactPojo.getMessage() %> <br>
		DATE-TIME > <%= readContactPojo.getDatetime() %><br>
		
		<form action="DeleteContact" method="post">
		<input type="hidden" name="sn" value="<%= readContactPojo.getSn() %>"> 
		<button>Delete</button>
		</form>

<%
		}
%>
 
 	<a href="ReadContact">Refresh</a>
</body>
</html>