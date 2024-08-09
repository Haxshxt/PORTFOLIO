package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AdminLoginServiceImpl;

/**
 * Servlet implementation class ChangeCredential2
 */
@WebServlet("/ChangeCredential2")
public class ChangeCredential2 extends HttpServlet {
	private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sn = request.getParameter("sn");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
//		int sn = Integer.parseInt(snn);
		
		AdminLoginServiceImpl adminLoginServiceImpl =new AdminLoginServiceImpl();
		result =adminLoginServiceImpl.updateAdminLoginService(sn, username, password);
		
		if(result.equals("updated")) {
			session.setAttribute("msg","updated successfully");
			response.sendRedirect("readContact.jsp");
		}else {
			session.setAttribute("msg", result);
			response.sendRedirect("readContact.jsp");
		}
		
		
		
		
		
	}

}
