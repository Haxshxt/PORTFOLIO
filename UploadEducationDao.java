package dao;

import java.util.ArrayList;

import model.EducationPojo;

public interface UploadEducationDao {

	public String insertdEducation(String year, String title, String subtitle, String description);
	public ArrayList<EducationPojo> readEducation();
	public String deleteEducation(int sn);
	public String updateEducation(int sn ,String year, String title, String subtitle, String description,String datetime);
}
