package service;

import java.util.ArrayList;

import dao.ExperienceDaoImpl;
import model.EducationPojo;
import model.ExperiencePojo;
import validation.ExperienceValidationImpl;

public class ExperienceServiceImpl implements ExperienceService {
	
	ExperienceDaoImpl experienceDaoImpl = new ExperienceDaoImpl();
	ExperienceValidationImpl experienceValidationImpl = new ExperienceValidationImpl();

	@Override

	public String insertExperience1(String year, String title, String subtitle, String description) {
	
		String insertExperienceValidationStatus = experienceValidationImpl.insertExperienceValidation(year, title, subtitle, description);
		return insertExperienceValidationStatus;
	}

	@Override
	public String insertExperience2(String year, String title, String subtitle, String description) {
		
		String insertExperienceServiceStatus = experienceDaoImpl.insertExperience(year, title, subtitle, description);
		
		return insertExperienceServiceStatus;
	}

	@Override
	public ArrayList<ExperiencePojo> readAllExperience() {
		
		ArrayList<ExperiencePojo> readAllExperienceArrayList = experienceDaoImpl.readAllExperience();
		return readAllExperienceArrayList;
	}

	@Override
	public String deleteExperience(String snn) {
		int sn = Integer.parseInt(snn);
		String deleteExperienceServiceStatus = experienceDaoImpl.deleteExperience(sn);
		return deleteExperienceServiceStatus;
	}

	@Override
	public String updateExperience(String snn ,String year , String title , String subtitle , String description) {
		int sn = Integer.parseInt(snn);
		String updateExperienceServiceStatus = experienceDaoImpl.updateExperience(sn, year, title, subtitle, description);
		return updateExperienceServiceStatus;
	}

	

}
