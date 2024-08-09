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
 * Servlet implementation class AdminServlet2
 */
@WebServlet("/AdminLogin2")
public class AdminLogin2 extends HttpServlet {
	
	private String result;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session =  request.getSession();
		
		AdminLoginServiceImpl adminLoginService = new AdminLoginServiceImpl();
		result=adminLoginService.adminLoginService2(username, password);
		
		if(result.equals("exists")) {
			session.setAttribute("adminlogin", username);
			response.sendRedirect("admin.jsp");
		}else {
			session.setAttribute("msg", result);
			response.sendRedirect("adminLogin.jsp");
		}
	}

}
