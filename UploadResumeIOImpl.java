package fileIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

public class UploadResumeIOImpl implements UploadResumeIO {

	private InputStream is ;
	private FileOutputStream fos ;
	private String result;
	private boolean deleteStatus;
	
	public boolean isExists(Part part) {
		boolean exists = false;
		
		try {
			String path ="C:\\Users\\Harshit\\eclipse-workspace-ADVANCE-JAVA\\project\\src\\main\\webapp\\myresume\\mycv.pdf";
			File file = new File(path);
			 exists = file.exists();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return exists;
	}
	
	public String uploadResume(Part part) {
		
		try {
			String path ="C:\\Users\\Harshit\\eclipse-workspace-ADVANCE-JAVA\\project\\src\\main\\webapp\\myresume\\mycv.pdf";
			
			 is = part.getInputStream();
			byte[] b = new byte[is.available()];
			is.read(b);
			
			 fos = new FileOutputStream(path);
			fos.write(b);
			result="uploaded";
		}catch(Exception e) {
			result="not uploaded";
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	public boolean deleteResume() {
		try {
			String path ="C:\\Users\\Harshit\\eclipse-workspace-ADVANCE-JAVA\\project\\src\\main\\webapp\\myresume\\mycv.pdf";
			File file = new File(path);
			deleteStatus = file.delete();
			 
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return deleteStatus;
		
	}

}
