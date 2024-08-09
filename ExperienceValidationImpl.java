package validation;

public class ExperienceValidationImpl implements ExperienceValidation {

	public String insertExperienceValidation(String year , String title , String subtitle , String description) {
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
