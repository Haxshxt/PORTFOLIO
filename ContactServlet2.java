package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ContactServiceImpl;

/**
 * Servlet implementation class ContactServlet2
 */
@WebServlet("/ContactServlet2")
public class ContactServlet2 extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		HttpSession session = request.getSession();
		
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		String result=contactServiceImpl.contactService2(name, email, message);
		
		System.out.println(result);
		
		if(result.equals("saved")) {
			session.setAttribute("msg", "saved contact");
			response.sendRedirect("index.jsp");
		}else if(result.equals("failed")) {
			session.setAttribute("msg", "faled insertion");
			response.sendRedirect("index.jsp");
			
		}else {
			session.setAttribute("msg","Something went wrong !! ");
			response.sendRedirect("index.jsp");
		}
		
			
	// response.sendRedirect("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwi_oung7PWEAxXhRmwGHS56DfsQPAgJ");
	}

}
