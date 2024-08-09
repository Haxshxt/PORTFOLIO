package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ExperienceServiceImpl;

/**
 * Servlet implementation class AddExperience2
 */
@WebServlet("/AddExperience2")
public class AddExperience2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String year = request.getParameter("year");
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String description = request.getParameter("description");
		 
		HttpSession session = request.getSession();
		
		ExperienceServiceImpl experienceServiceImpl = new ExperienceServiceImpl();
		String insertExperience2Status = experienceServiceImpl.insertExperience2(year, title, subtitle, description);
		
		session.setAttribute("msg", insertExperience2Status);
		response.sendRedirect("addExperiences.jsp");;
		
	}

}
