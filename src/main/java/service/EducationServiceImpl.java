package service;

import java.util.ArrayList;

import dao.UploadEducationDaoImpl;
import model.EducationPojo;

public class EducationServiceImpl implements EducationService {
	UploadEducationDaoImpl uploadEducationDaoImpl = new UploadEducationDaoImpl();
	
   public String insertEducation2(String year, String title, String subtitle, String description) {
	   
	   
	   String uploadEducationDaoStatus = uploadEducationDaoImpl.insertdEducation(year,title,subtitle,description);
		return uploadEducationDaoStatus;
	}

@Override
public ArrayList<EducationPojo> readEducation() {
	// TODO Auto-generated method stub
	ArrayList<EducationPojo> list = uploadEducationDaoImpl.readEducation();
	
	return list;
}

@Override
public String deleteEducation(String snn) {
	
	int sn =Integer.parseInt(snn);
	String deleteEducationServiceStatus = uploadEducationDaoImpl.deleteEducation(sn);
	return deleteEducationServiceStatus;
}

@Override
public String updateEducation(String snn, String year, String title, String subtitle, String description, String datetime) {
	int sn =Integer.parseInt(snn);
	String updateEducationServiceStatus = uploadEducationDaoImpl.updateEducation(sn, year, title, subtitle, description, datetime);
	
	return updateEducationServiceStatus;
}



}
