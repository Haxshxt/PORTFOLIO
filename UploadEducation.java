package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UploadProjectServiceImpl;

/**
 * Servlet implementation class UploadEducation
 */
@WebServlet("/UploadEducation")
public class UploadEducation extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String year = request.getParameter("year");
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String description = request.getParameter("description");
		
		HttpSession session = request.getSession();
		
		UploadProjectServiceImpl uploadProjectServiceImpl = new UploadProjectServiceImpl();
		String uploadEducationService1Status = uploadProjectServiceImpl.uploadEducationService1(year, title, subtitle, description);
		
		if(uploadEducationService1Status.equals("valid")) {
			RequestDispatcher rd = request.getRequestDispatcher("UploadEducation2");
			rd.forward(request, response);
		}else {
			session.setAttribute("msg", uploadEducationService1Status);
			response.sendRedirect("addEducation.jsp");
		}
	}

}
