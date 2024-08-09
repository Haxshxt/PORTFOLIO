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
 * Servlet implementation class UpdateExperience
 */
@WebServlet("/UpdateExperience")
public class UpdateExperience extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String snn = request.getParameter("sn");
		String year = request.getParameter("year");
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String description = request.getParameter("description");
		
		HttpSession session = request.getSession();
		
		ExperienceServiceImpl experienceServiceImpl = new ExperienceServiceImpl();
		
		String updateExperience = experienceServiceImpl.updateExperience(snn, year, title, subtitle, description);
		
		if(updateExperience.equals("updated")) {
			session.setAttribute("msg", updateExperience);
			response.sendRedirect("ReadExperience");
		}else {
			session.setAttribute("msg", updateExperience);
			response.sendRedirect("updateExperience.jsp");
		}
		
		
	}

}
