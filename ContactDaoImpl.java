package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ReadContactPojo;

public class ContactDaoImpl implements ContactDao {
    
    private Connection conn;
    private PreparedStatement ps;
    private String result;
    private ArrayList<ReadContactPojo> list;
    private String sql;

    @SuppressWarnings("finally")
	@Override
    public String insertContact(String name, String email, String message, String time) {
       
        
        try {
            conn = ConnectionFactory.getConnection();
           
            
           
      sql = "INSERT INTO myPortfolio.contact(name, email, message, time) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, message);
            ps.setString(4, time);
            
            int row = ps.executeUpdate();
            if (row > 0) {
                result = "saved";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result="failed";
        } 
        	 return result;
           
        
       
    }

	@Override
	public ArrayList<ReadContactPojo> readContact() {
		 list = new ArrayList<>();
		
		try {
			conn = ConnectionFactory.getConnection();
			  
			   sql = "select * from myPortfolio.contact ";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs = ps.executeQuery();
			   
			   while(rs.next()) {
				   ReadContactPojo obj =  new ReadContactPojo(rs.getInt("sn"), rs.getString("name"), rs.getString("email"), rs.getString("message"), rs.getString("time"));
				   list.add(obj);
			   }
			  
		}catch(Exception e) {
			e.printStackTrace();
			list.clear();
			
		}
		  
		  
		return list;
	}

	public String deleteContact(String sn) {
		try {
			int snn = Integer.parseInt(sn);
			conn= ConnectionFactory.getConnection();
			sql="delete from myPortfolio.contact where sn=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, snn);
			int row = ps.executeUpdate();
			if(row==1) {
				result="deleted";
			}else {
				result="not deleted";
			}
		}catch(Exception e) {
			e.printStackTrace();
			result="something went wrong";
			
		}
		return result;
		
		
	}
	
	/*
	public static void main(String[] args) {
		
		ContactDaoImpl obj = new ContactDaoImpl();
		
		ArrayList<ReadContactPojo> list = obj.readContact();
		
		System.out.println(list);
		
	}
    
    */
  
}
