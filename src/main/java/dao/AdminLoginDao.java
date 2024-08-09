package dao;

import model.ReadAdminLoginPojo;

public interface AdminLoginDao {

	public String readAdminLogin(String username , String password);
	public ReadAdminLoginPojo readAdminLoginData();
    public String updateAdminLoginDetails(String sn , String username , String password);
}
