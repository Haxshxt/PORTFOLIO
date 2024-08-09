package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UploadProjectServiceImpl;

/**
 * Servlet implementation class DeleteProject
 */
@WebServlet("/DeleteProject")
public class DeleteProject extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("sn");
		String formatedFileName = request.getParameter("formatedfilename");
		HttpSession session = request.getSession();
		
		ServletContext servletContext = getServletContext();
		String realPath = servletContext.getRealPath("myproject");
		
		UploadProjectServiceImpl uploadProjectServiceImpl = new UploadProjectServiceImpl();
		String deleteUploadProjectStatus = uploadProjectServiceImpl.deleteUploadProject(id, formatedFileName,realPath);
		
		if(deleteUploadProjectStatus.equals("deleted")) {
			session.setAttribute("msg", deleteUploadProjectStatus);
			response.sendRedirect("readProjects.jsp");
		}else {
			session.setAttribute("msg", deleteUploadProjectStatus);
			response.sendRedirect("readProjects.jsp");
		}
	}

}
