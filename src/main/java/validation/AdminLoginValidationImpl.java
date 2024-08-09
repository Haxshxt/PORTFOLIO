package validation;

import java.sql.Connection;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

public class AdminLoginValidationImpl implements AdminLoginValidation {

	
	private String result;
	public String adminLoginValidation(String username, String password) {
		
		if(username.length()<6||username.length()>20) {
			result="invalid username length";
		}else if(password.length()<6||password.length()>20) {
			result="invalid password length";
		}else {
			result="valid";
		}
		return result;
	}
	@Override
	public String updateAdminLoginDetailsValidation(String username, String password) {
		if(username.length()<6||username.length()>20) {
			result="invalid username length";
		}else if(password.length()<6||password.length()>20) {
			result="invalid password length";
		}else {
			result="valid";
		}
		return result;
	}

}
