package fileIO;

import javax.servlet.http.Part;

public interface ProjectIO {
	
	public boolean writeProject(Part part , String formatedFileName  , String realPath);
	public boolean deleteProject(String formatedFileName,String realPath);

}
