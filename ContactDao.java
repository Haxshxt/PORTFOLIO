package dao;

import java.util.ArrayList;

import model.ReadContactPojo;

public interface ContactDao {
	
	public String insertContact(String name ,String email , String message , String datetime);
    public ArrayList<ReadContactPojo> readContact();
    public String deleteContact(String sn);
}
