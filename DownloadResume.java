package controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadResume
 */
@WebServlet("/DownloadResume")
public class DownloadResume extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ab download krni hai vo pdf ( mycv.pdf) 
		// read to ye normal input stream se hi hojayegi kuki file server pe h 
		// magar download client k system me krni haiiii to vha output stream hm response ojbect se lenge kuki client li location hume pata nhi hai vo different different hogi fixed nhi h but input stream ki location fixed h myresume folder k ander mycv.pdf
		
		
		String path ="C:\\Users\\Harshit\\eclipse-workspace-ADVANCE-JAVA\\project\\src\\main\\webapp\\myresume\\mycv.pdf";
		FileInputStream is = new FileInputStream(path);
		byte[] b = new byte[is.available()];
		is.read(b);
		
		
		ServletOutputStream os = response.getOutputStream();
		response.setHeader("content-disposition", "filename=mycv.pdf");//synatax h ye 
		response.setContentType("appliaction/octet-stream");
		os.write(b);
		
		is.close();
		os.close();
	}

	


}
