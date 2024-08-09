package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.EducationPojo;
import model.UploadProjectPojo;

public class UploadEducationDaoImpl implements UploadEducationDao {
	

	private Connection conn;
	private String sql;
	private int row;
	private ResultSet rs;
	private PreparedStatement ps;
	private String result;
	@Override
	public String insertdEducation(String year, String title, String subtitle, String description) {
		try {
			conn=ConnectionFactory.getConnection();
			sql="insert into myPortfolio.education(year,title,subtitle,description,datetime) values (?,?,?,?,?)";
			String datetime =  LocalDateTime.now().toString();
			ps = conn.prepareStatement(sql);
			ps.setString(1, year);
			ps.setString(2, title);
			ps.setString(3, subtitle);
			ps.setString(4, description);
			ps.setString(5,datetime);
			row = ps.executeUpdate();
			if(row==1) {
				result="saved";
			}else {
				result="not saved";
			}
		
			
		}catch(Exception e) {
			result="something went wrong";
			e.printStackTrace();
			
		}
	
		
		return result;
	}
	@Override
	public ArrayList<EducationPojo> readEducation() {
		ArrayList<EducationPojo> list = new ArrayList<>();
		try {
		 conn = ConnectionFactory.getConnection();
			sql="select * from myPortFolio.education";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				EducationPojo obj = new EducationPojo(rs.getInt("sn"),rs.getString("year"),rs.getString("title"),rs.getString("subtitle"),rs.getString("description"),rs.getString("datetime"));
				list.add(obj);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public String deleteEducation(int sn) {
		try {
			conn=ConnectionFactory.getConnection();
			sql="delete from myPortfolio.education where sn = ?";
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
	@Override
	public String updateEducation(int sn ,String year, String title, String subtitle, String description,String datetime) {
		try {
			conn=ConnectionFactory.getConnection();
			sql="update myPortfolio.education set year=?,title=?,subtitle=?,description=?,datetime=? where sn=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, year);
			ps.setString(2, title);
			ps.setString(3, subtitle);
			ps.setString(4, description);
			ps.setString(5,datetime);
			ps.setInt(6,sn);
			row = ps.executeUpdate();
			if(row==1) {
				result="updated";
			}else {
				result="not updated";
			}
		
			
		}catch(Exception e) {
			result="something went wrong";
			e.printStackTrace();
			
		}
	
		
		return result;
	}

}
