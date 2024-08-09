package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class UploadProject1
 */
@WebServlet("/UploadProject1")
@MultipartConfig
public class UploadProject1 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Part part = request.getPart("myFile");
	//	InputStream inputStream = part.getInputStream();
		String datetime = request.getParameter("datetime");
		String submittedFileName = part.getSubmittedFileName();
		
//		System.out.println(submittedFileName+ "  "+ datetime );
		
		//REAL PATH 
		
	
		
		UploadProjectServiceImpl uploadProjectService = new UploadProjectServiceImpl();
		String result = uploadProjectService.uploadProjectService1(part);
		
		if(result.equals("valid")) {
			// dispatch
			RequestDispatcher rd = request.getRequestDispatcher("UploadProject2");
			rd.forward(request, response);
		}else {
			session.setAttribute("msg", result);
			response.sendRedirect("uploadProject.jsp");
		}
		
	}

}
