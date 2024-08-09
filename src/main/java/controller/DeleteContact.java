package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ContactServiceImpl;

/**
 * Servlet implementation class DeleteContact
 */
@WebServlet("/DeleteContact")
public class DeleteContact extends HttpServlet {
	private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String sn =	request.getParameter("sn");
	HttpSession session = request.getSession();
	
	ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
	result= contactServiceImpl.deleteContact(sn);
	
	if(result.equals("deleted")) {
		session.setAttribute("msg","deleted successfully");
		response.sendRedirect("ReadContact");
	}else {
		session.setAttribute("msg",result);
		response.sendRedirect("readContact.jsp");
	}
	}

}
