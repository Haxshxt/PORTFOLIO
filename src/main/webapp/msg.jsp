<%

String message = (String)session.getAttribute("msg");
if(message!=null){
	
%>

 <h1 style="text-align: center;"><%=message %></h1>
 
 <%
 
 session.removeAttribute("msg");
}
 
 %>