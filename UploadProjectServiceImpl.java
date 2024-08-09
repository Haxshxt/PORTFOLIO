package service;

import java.io.File;
import java.sql.Connection;
import java.time.LocalDateTime;

import javax.servlet.http.Part;

import dao.ConnectionFactory;
import dao.UploadProjectDaoImpl;
import fileIO.ProjectIO;
import fileIO.ProjectIOImpl;
import validation.UploadProjectValidationImpl;

public class UploadProjectServiceImpl implements UploadProjectService {

	private String result;
	
	@Override
	public String uploadProjectService1(Part part) {
		// validation 
		UploadProjectValidationImpl uploadProjectValidationImpl = new UploadProjectValidationImpl();
		 result = uploadProjectValidationImpl.uploadProjectValidation(part);
		return result;
	}
	
	@Override
	public String uploadProjectService2(Part part, String datetime,String realPath) {
		
		//DAO
		try {
		
			String submittedFileName = part.getSubmittedFileName();
			
			String systemDateTime = LocalDateTime.now().toString();
			String split[] = systemDateTime.split(":");
			String	formatedDateTime="";
			for(int i=0;i<split.length;i++) {
				formatedDateTime = formatedDateTime+split[i];
			}
			
			String formatedFileName = formatedDateTime+submittedFileName;
			
			Connection conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			
			UploadProjectDaoImpl uploadProjectDaoImpl = new UploadProjectDaoImpl();
			String result = uploadProjectDaoImpl.uploadProject(formatedFileName, formatedDateTime, conn);
			
			if(result.equals("uploaded")) {
				ProjectIOImpl projectIOImpl = new ProjectIOImpl();
				boolean status = projectIOImpl.writeProject(part, formatedFileName,realPath);
				if(status) {
					conn.commit();
					this.result="uploaded";
				}else {
					conn.rollback();
					this.result="not uploaded";
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			this.result="something went wrong";
		}
		
		return result;
	}

	@Override
	public String deleteUploadProject(String id,String formatedFileName,String realPath) {
		
		try {
			int getSn = Integer.parseInt(id);
			Connection conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			UploadProjectDaoImpl uploadProjectDaoImpl= new UploadProjectDaoImpl();
		    result = uploadProjectDaoImpl.deleteUploadedProject(getSn, conn);
			if(result.equals("deleted")) {
				
				// folder se bhi delete kro
				ProjectIOImpl projectIOImpl = new ProjectIOImpl();
				boolean deleteProjectStatus = projectIOImpl.deleteProject(formatedFileName,realPath);
				if(deleteProjectStatus) {
					result="deleted";
					conn.commit();
				}else {
					conn.rollback();
					
					
				}
				
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	
		return result;
	}

	@Override
	public String uploadEducationService1(String year, String title, String subtitle, String description) {
		UploadProjectValidationImpl uploadProjectValidationImpl = new UploadProjectValidationImpl();
		String uploadEducationValidationStatus = uploadProjectValidationImpl.uploadEducationValidation(year, title, subtitle, description);
		return uploadEducationValidationStatus;
	}
	
	

}
