package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ExperiencePojo;
import service.ExperienceServiceImpl;

/**
 * Servlet implementation class ReadExperience
 */
@WebServlet("/ReadExperience")
public class ReadExperience extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ExperienceServiceImpl experienceServiceImpl = new ExperienceServiceImpl();
		ArrayList<ExperiencePojo> readAllExperience = experienceServiceImpl.readAllExperience();
		HttpSession session = request.getSession();
		session.setAttribute("readExperienceArrayList", readAllExperience);
		
		response.sendRedirect("readExperience.jsp");;
	}

	

}
