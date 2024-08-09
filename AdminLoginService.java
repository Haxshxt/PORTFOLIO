package service;

import model.ReadAdminLoginPojo;

public interface AdminLoginService {
	
	public String adminLoginService(String username,String password);
	public String adminLoginService2(String username,String password);
	public ReadAdminLoginPojo  readAdminLoginService();
	public String updateAdminLoginService(String username,String password);
	public String updateAdminLoginService(String sn ,String username,String password);
	

}
