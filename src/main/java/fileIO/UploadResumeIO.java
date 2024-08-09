package fileIO;

import javax.servlet.http.Part;

public interface UploadResumeIO {

	public boolean isExists(Part part);
	
	public String uploadResume(Part part);
	public boolean deleteResume();
}
