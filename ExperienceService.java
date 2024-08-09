package service;

import java.util.ArrayList;

import model.ExperiencePojo;

public interface ExperienceService {

	public String insertExperience1(String year , String title , String subtitle , String description);
	public String insertExperience2(String year , String title , String subtitle , String description);
	public ArrayList<ExperiencePojo> readAllExperience();
	public String updateExperience(String sn ,String year , String title , String subtitle , String description);
	public String deleteExperience(String sn);
}
