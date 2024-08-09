package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ContactServiceImpl;

/**
 * Servlet implementation class ContactServlet1
 */
@WebServlet("/ContactServlet1")
public class ContactServlet1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String name =	request.getParameter("name");
	String email =	request.getParameter("email");
	String message =	request.getParameter("message");
	
	
	HttpSession session = request.getSession();
	
	
	ContactServiceImpl contactServiceImpl1 =  new ContactServiceImpl();
	String result = contactServiceImpl1.contactService1(name, email, message);
	
	if(result.equals("Valid")) {
		RequestDispatcher rd = request.getRequestDispatcher("ContactServlet2");
		 rd.forward(request, response);
	}else {
		session.setAttribute("msg", result);
		response.sendRedirect("index.jsp");
	}
  }

}
