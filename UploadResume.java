package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import service.UploadResumeImpl;

/**
 * Servlet implementation class UploadResume
 */
@MultipartConfig
@WebServlet("/UploadResume")
public class UploadResume extends HttpServlet {
	
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part resume = request.getPart("resume");
		
		UploadResumeImpl uploadResumeImpl = new UploadResumeImpl();
		String uploadResumeStatus = uploadResumeImpl.uploadResume(resume);
		HttpSession session = request.getSession();
		session.setAttribute("msg", uploadResumeStatus);
		response.sendRedirect("uploadResume.jsp");
	}

}
