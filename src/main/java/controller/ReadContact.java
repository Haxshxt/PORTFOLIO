package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ReadContactPojo;
import service.ContactServiceImpl;

/**
 * Servlet implementation class ReadContact
 */
@WebServlet("/ReadContact")
public class ReadContact extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		ArrayList<ReadContactPojo> arrayList =	contactServiceImpl.readContactService();
		
		HttpSession session = request.getSession();
		session.setAttribute("readcontact", arrayList);
		response.sendRedirect("readContact.jsp");
	
	
	}

	

}
