package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.UploadProjectPojo;

public class UploadProjectDaoImpl implements UploadProjectDao {


	
    private PreparedStatement ps;
    private String result;
    private String sql;
    private int row;
    private ResultSet rs;
    
	public String uploadProject(String formatedFileName, String datetime , Connection connection) {
		
		
		try {
			sql="insert into myPortfolio.project(formatedFileName,datetime) values(?,?)";
			ps=connection.prepareStatement(sql);
			ps.setString(1, formatedFileName);
			ps.setString(2, datetime);
		    row=ps.executeUpdate();
		    if(row==1) {
		    	result="uploaded";
		    }else {
		    	result="not uploaded";
		    }
		}catch(Exception e) {
			result="something went wrong";
			e.printStackTrace();
			
		}
		return result;
	}
	@Override
	public ArrayList<UploadProjectPojo> readAllProjects() {
		ArrayList<UploadProjectPojo> list = new ArrayList<>();
		try {
			Connection conn = ConnectionFactory.getConnection();
			sql="select * from myPortFolio.project";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				UploadProjectPojo obj = new UploadProjectPojo(rs.getInt("id"),rs.getString("formatedFileName"),rs.getString("datetime"));
				list.add(obj);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	@Override
	public String deleteUploadedProject(int sn, Connection conn) {
		
		try {
			
			sql="delete from myPortfolio.project where id = ?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sn);
		    row = ps.executeUpdate();
		    if(row==1) {
		    	result="deleted";
		    }else {
		    	result="failed";
		    }
			
		}catch(Exception e) {
			result="something went wrong";
			e.printStackTrace();
			
		}
		return result;
	}
	
	

}
