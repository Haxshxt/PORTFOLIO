package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EducationPojo;
import service.EducationServiceImpl;

/**
 * Servlet implementation class ReadEducation
 */
@WebServlet("/ReadEducation")
public class ReadEducation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EducationServiceImpl educationServiceImpl = new EducationServiceImpl();
		ArrayList<EducationPojo> readEducationArrayList = educationServiceImpl.readEducation();
		
		session.setAttribute("readEducationArrayList", readEducationArrayList);
		response.sendRedirect("readEducation.jsp");
	
		}
		
	}

	


