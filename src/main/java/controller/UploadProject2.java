package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import service.UploadProjectServiceImpl;

/**
 * Servlet implementation class UploadProject2
 */
@WebServlet("/UploadProject2")
@MultipartConfig
public class UploadProject2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part part = request.getPart("myFile");
		String datetime = request.getParameter("datetime");
		String submittedFileName = part.getSubmittedFileName();
		
		ServletContext servletContext = getServletContext();
		String realPath = servletContext.getRealPath("myproject");
		
		UploadProjectServiceImpl uploadProjectServiceImpl = new UploadProjectServiceImpl();
		String resut = uploadProjectServiceImpl.uploadProjectService2(part, datetime, realPath);
		
		HttpSession session = request.getSession();
		session.setAttribute("msg", resut);
		response.sendRedirect("uploadProject.jsp");
	}

}
