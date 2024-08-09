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
 * Servlet implementation class DeleteExperience
 */
@WebServlet("/DeleteExperience")
public class DeleteExperience extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String snn = request.getParameter("sn");
		ExperienceServiceImpl experienceServiceImpl = new ExperienceServiceImpl();
		String deleteExperienceStatus = experienceServiceImpl.deleteExperience(snn);
		
		HttpSession session = request.getSession();
		session.setAttribute("msg", deleteExperienceStatus);
		response.sendRedirect("ReadExperience");
	}

}
// DeleteExperience