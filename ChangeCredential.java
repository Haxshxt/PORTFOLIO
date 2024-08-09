package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AdminLoginServiceImpl;
import validation.AdminLoginValidationImpl;

/**
 * Servlet implementation class ChangeCredential
 */
@WebServlet("/ChangeCredential")
public class ChangeCredential extends HttpServlet {
	
	private String result;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sn = request.getParameter("sn");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		AdminLoginServiceImpl adminLoginService=	new AdminLoginServiceImpl();
		
		result = adminLoginService.updateAdminLoginService(username, password);
		if(result.equals("valid")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("ChangeCredential2");
			rd.forward(request, response);
			
		}else {
			session.setAttribute("msg", result);
			response.sendRedirect("readContact.jsp");
		}
	}

}
