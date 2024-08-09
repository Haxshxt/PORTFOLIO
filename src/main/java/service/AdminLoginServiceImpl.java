package service;

import dao.AdminLoginDaoImpl;
import model.ReadAdminLoginPojo;
import validation.AdminLoginValidationImpl;

public class AdminLoginServiceImpl implements AdminLoginService {
	
	private String result;

	@Override
	public String adminLoginService(String username, String password) {
		
		AdminLoginValidationImpl adminLoginValidationImpl=new AdminLoginValidationImpl();
		result=adminLoginValidationImpl.adminLoginValidation(username, password);
		
		return result;
	}

	@Override
	public String adminLoginService2(String username, String password) {
		
		AdminLoginDaoImpl adminLoginDaoImpl=	new AdminLoginDaoImpl();
		result=adminLoginDaoImpl.readAdminLogin(username, password);
		
		return result;
	}

	@Override
	public ReadAdminLoginPojo readAdminLoginService() {
		
		AdminLoginDaoImpl adminLoginDaoImpl = new AdminLoginDaoImpl();
		ReadAdminLoginPojo readAdminLoginData=adminLoginDaoImpl.readAdminLoginData();
		return readAdminLoginData;
	}

	@Override
	public String updateAdminLoginService(String username, String password) {
		
		AdminLoginValidationImpl adminLoginValidation=new AdminLoginValidationImpl();
		result=adminLoginValidation.updateAdminLoginDetailsValidation(username, password);
		return result;
	}

	@Override
	public String updateAdminLoginService(String sn, String username, String password) {
		AdminLoginDaoImpl adminLoginDao =	new AdminLoginDaoImpl();
		result=adminLoginDao.updateAdminLoginDetails(sn, username, password);
		return result;
	}

}
