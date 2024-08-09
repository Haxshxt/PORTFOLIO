package service;

import javax.servlet.http.Part;

import fileIO.UploadResumeIOImpl;

public class UploadResumeImpl implements UploadResumeService {

	public String result;
	public String uploadResume(Part part) {
	
		// ab sbse phehle ye check krege ki ye esume jo aaya hai vo exists krta hai ya nhi 
		//  agar krta hua to update krege vrna upload > fileio pe
		
		UploadResumeIOImpl uploadResumeIOImpl = new UploadResumeIOImpl();
		
		boolean status = uploadResumeIOImpl.isExists(part);
		
		if(status) {
			// agar true hua to UPDATE krna hai > Delete -> Upload
			boolean deleteResumeStatus = uploadResumeIOImpl.deleteResume();
			if(deleteResumeStatus) {
				String uploadResumeStatus = uploadResumeIOImpl.uploadResume(part);
				if(uploadResumeStatus.equals("uploaded")) {
					result="updated";
				}else {
					result="not updated";
				}
			}
			
		}else {
			// sidha upload 
			String uploadResumeStatus = uploadResumeIOImpl.uploadResume(part);
			if(uploadResumeStatus.equals("uploaded")) {
				result="uploaded";
			}else {
				result="not uploaded";
			}
		}
		
		
		return result;
	}

}
