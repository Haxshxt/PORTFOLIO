package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EducationServiceImpl;
import service.UploadProjectServiceImpl;

/**
 * Servlet implementation class UploadEducation2
 */
@WebServlet("/UploadEducation2")
public class UploadEducation2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String year = request.getParameter("year");
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String description = request.getParameter("description");
		
		HttpSession session = request.getSession();
		
		EducationServiceImpl educationServiceImpl = new EducationServiceImpl();
		String uploadEducationService2Status = educationServiceImpl.insertEducation2(year, title, subtitle, description);
		if(uploadEducationService2Status.equals("saved")) {
			session.setAttribute("msg", "uploaded");
			response.sendRedirect("addEducation.jsp");
		}
		
		
	}

}
