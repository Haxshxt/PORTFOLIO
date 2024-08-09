package fileIO;

import java.io.*;

import javax.servlet.http.Part;

public class ProjectIOImpl implements ProjectIO {

	private boolean result;
	private String path;
	private FileOutputStream fileOutputStream ;
	private InputStream inputStream ;
	@Override
	public boolean writeProject(Part part, String formatedFileName , String realPath) {
		
		try {
			
			// file lo byte me convt kro read kro
			 inputStream = part.getInputStream();
			byte b[] = new byte[inputStream.available()];
			inputStream.read(b);
			
			//ab apni asli jgh pe daalo -> myproject folder me 
	//		path="C:\\Users\\Harshit\\eclipse-workspace-ADVANCE-JAVA\\project\\src\\main\\webapp\\myproject\\" + formatedFileName;
			
			fileOutputStream = new FileOutputStream(realPath+File.separator+formatedFileName);
			fileOutputStream.write(b);
			result=true;
		
			
		}catch(Exception e) {
			
		}finally {
			try {
				fileOutputStream.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				inputStream.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	@Override
	public boolean deleteProject(String formatedFileName,String realPath) {
		
		try {
			
	//		path="C:\\Users\\Harshit\\eclipse-workspace-ADVANCE-JAVA\\project\\src\\main\\webapp\\myproject\\" + formatedFileName;
			
			File file = new File(realPath+File.separator+formatedFileName);
			boolean result=file.delete();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
