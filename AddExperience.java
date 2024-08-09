package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EducationServiceImpl;
import service.ExperienceServiceImpl;

/**
 * Servlet implementation class AddExperience
 */
@WebServlet("/AddExperience")
public class AddExperience extends HttpServlet {
	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String year = request.getParameter("year");
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String description = request.getParameter("description");
		 
		HttpSession session = request.getSession();
		
		ExperienceServiceImpl experienceServiceImpl = new ExperienceServiceImpl();
		String insertExperience1Status = experienceServiceImpl.insertExperience1(year, title, subtitle, description);
		if(insertExperience1Status.equals("valid")) {
			RequestDispatcher rd = request.getRequestDispatcher("AddExperience2");
			rd.forward(request, response);
		}else {
			session.setAttribute("msg", insertExperience1Status);
			response.sendRedirect("addExperiences.jsp");
		}
	}

}
