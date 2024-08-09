package dao;

import java.sql.Connection;
import java.util.ArrayList;

import model.UploadProjectPojo;

public interface UploadProjectDao {
	
	public String uploadProject(String formatedFileName , String datetime , Connection connection);
	public ArrayList<UploadProjectPojo> readAllProjects();
	public String deleteUploadedProject(int sn , Connection conn);
 
		
		
	}

