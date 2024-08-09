package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EducationServiceImpl;

/**
 * Servlet implementation class DeleteEducation
 */
@WebServlet("/DeleteEducation")
public class DeleteEducation extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String snn = request.getParameter("sn");
		HttpSession session = request.getSession();
		EducationServiceImpl educationServiceImpl = new EducationServiceImpl();
		String deleteEducationStatus = educationServiceImpl.deleteEducation(snn);
		
		session.setAttribute("msg", deleteEducationStatus);
		response.sendRedirect("ReadEducation");
	}

}
