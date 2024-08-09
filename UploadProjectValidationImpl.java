package validation;

import javax.servlet.http.Part;

public class UploadProjectValidationImpl implements UploadProjectValidation {
	private String result;
	@Override
	public String uploadProjectValidation(Part part) {
		try {
			
			long size = part.getSize(); 
			String contentType = part.getContentType();
			
			if(size>1048576) {
				result="size execced";
			}else if(!contentType.startsWith("image")) {
				result="invalid format";
			}else {
				result="valid";
			}
			
		}catch(Exception e) {
			result="something went wrong";
			e.printStackTrace();
			
		}
		return result;
	}
	@Override
	public String uploadEducationValidation(String year, String title, String subtitle, String description) {
		String result="invalid";
		
		int yearLength= year.length();
		int titleLength=title.length();
		int subtitileLength=subtitle.length();
		int descriptionLength=description.length();
			
		if(yearLength!=4) {
			result="invalid year length";
		}else if(titleLength<2||titleLength>30) {
			result="invalid title length";
		}else if(subtitileLength<2||subtitileLength>40) {
			result="invalid subtitle length";
		}else if(descriptionLength<2|| descriptionLength>50) {
			result="invalid description length";
		}else {
			result="valid";
		}
		
		return result;
	}

}
