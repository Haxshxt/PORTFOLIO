package controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EducationServiceImpl;

/**
 * Servlet implementation class UpdateEducation
 */
@WebServlet("/UpdateEducation")
public class UpdateEducation extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String snn = request.getParameter("sn");
		String year = request.getParameter("year");
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String description = request.getParameter("description");
		
		HttpSession session = request.getSession();
		
		EducationServiceImpl educationServiceImpl = new EducationServiceImpl();
		String datetime = LocalDateTime.now().toString();
		String updateEducationStatus = educationServiceImpl.updateEducation(snn, year, title, subtitle, description, datetime);
		
		if(updateEducationStatus.equals("updated")) {
			response.sendRedirect("ReadEducation");
		}else {
			session.setAttribute("msg", updateEducationStatus);
			response.sendRedirect("readEducation.jsp");
		}
		
	}

}
