package service;

import javax.servlet.http.Part;

public interface UploadProjectService {
	
	public String uploadProjectService1(Part part);
	public String uploadProjectService2(Part part ,  String datetime,String realPath);
	public String deleteUploadProject(String id,String formatedFileName,String realPath);
	public String uploadEducationService1(String year , String title , String subtitle,String description);
}
