package dao;

import java.util.ArrayList;

import model.ExperiencePojo;

public interface ExperienceDao {

	public String insertExperience(String year , String title , String subtitle , String description);
	public ArrayList<ExperiencePojo> readAllExperience();
	public String deleteExperience(int sn);
	public String updateExperience(int sn ,String year , String title , String subtitle , String description);

}
