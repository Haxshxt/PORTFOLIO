package validation;

import javax.servlet.http.Part;

public interface UploadProjectValidation {
	
	public String uploadProjectValidation(Part part);
	public String uploadEducationValidation(String year, String title, String subtitle, String description);

}
