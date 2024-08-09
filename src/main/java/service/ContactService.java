package service;

import java.util.ArrayList;

import model.ReadContactPojo;

public interface ContactService {

	public String contactService1(String name , String email , String message);
	public String contactService2(String name , String email , String message);
	public ArrayList<ReadContactPojo> readContactService();
	public String deleteContact(String sn);
}
