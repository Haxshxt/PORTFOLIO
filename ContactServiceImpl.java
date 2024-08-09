package service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import dao.ContactDaoImpl;
import model.ReadContactPojo;
import validation.ContactValidationImpl;

public class ContactServiceImpl implements ContactService {

	private String result;
	@SuppressWarnings("finally")
	@Override
	public String contactService1(String name, String email, String message) {
		
		
			
			ContactValidationImpl  contactValidationImpl =	new ContactValidationImpl();
		result =	contactValidationImpl .contactValidation(name, email, message);
		
		
			return result;
		
		
	}
	@SuppressWarnings("finally")
	@Override
	public String contactService2(String name, String email, String message) {
		
		try {
			
		ContactDaoImpl contactDaoImpl =	new ContactDaoImpl();
		String time = LocalDateTime.now().toString();
		result=	contactDaoImpl.insertContact(name, email, message, time);

			
		}catch(Exception e) {
			e.printStackTrace();
			result="error";
			
		}
			return result;
		
	}
	@Override
	public ArrayList<ReadContactPojo> readContactService() {
		
		ContactDaoImpl contactDaoImpl =	new ContactDaoImpl();
		ArrayList<ReadContactPojo> list=	contactDaoImpl.readContact();
		
		return list;
	}
	@Override
	public String deleteContact(String sn) {
		
		ContactDaoImpl contactDaoImpl =	new ContactDaoImpl();
		result = contactDaoImpl.deleteContact(sn);
		return result;
	}
}
