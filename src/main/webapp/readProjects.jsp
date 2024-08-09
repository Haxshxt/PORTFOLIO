<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.UploadProjectDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.UploadProjectPojo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="msg.jsp" %>
  <%
                      	UploadProjectDaoImpl uploadProjectDao = new UploadProjectDaoImpl();
                        ArrayList<UploadProjectPojo> al = uploadProjectDao.readAllProjects();
                        		
                        for(UploadProjectPojo obj :al){
                        	
                        
                      %>
                      
                      <img alt="" width="100px" src="myproject/<%=obj.getFormatedFilename()%>">
                      <br>
                      <br>
                      
                      <form action="DeleteProject" method="post"> 
                      <input type="hidden" name="sn" value="<%=obj.getSn()%>">
                      <input type="hidden" name="formatedfilename" value="<%=obj.getFormatedFilename()%>">
                      <button>delete</button>
                      </form>
                     <%
                        }
                     %>
</body>
</html>