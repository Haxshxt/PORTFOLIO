package service;

import java.util.ArrayList;

import model.EducationPojo;

public interface EducationService {
	
	public ArrayList<EducationPojo> readEducation();
	public String deleteEducation(String sn);
	public String updateEducation(String snn , String year , String title,String subtitle,String description,String datetime);
}
