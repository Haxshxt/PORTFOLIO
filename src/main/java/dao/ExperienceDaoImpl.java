package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.EducationPojo;
import model.ExperiencePojo;

public class ExperienceDaoImpl implements ExperienceDao {

	private Connection conn;
	private String sql;
	private int row;
	private ResultSet rs;
	private PreparedStatement ps;
	private String result;
	@Override
	public String insertExperience(String year, String title, String subtitle, String description) {
		try {
			conn=ConnectionFactory.getConnection();
			sql="insert into myPortfolio.experience(year,title,subtitle,description) values (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, year);
			ps.setString(2, title);
			ps.setString(3, subtitle);
			ps.setString(4, description);
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
	public ArrayList<ExperiencePojo> readAllExperience() {
		ArrayList<ExperiencePojo> list = new ArrayList<>();
		try {
		 conn = ConnectionFactory.getConnection();
			sql="select * from myPortfolio.experience";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				ExperiencePojo obj = new ExperiencePojo(rs.getInt("sn"),rs.getString("year"),rs.getString("title"),rs.getString("subtitle"),rs.getString("description"));
				list.add(obj);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String deleteExperience(int sn) {
		try {
			conn=ConnectionFactory.getConnection();
			sql="delete from myPortfolio.experience where sn = ?";
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
	public String updateExperience(int sn ,String year , String title , String subtitle , String description) {
		try {
			conn=ConnectionFactory.getConnection();
			sql="update myPortfolio.experience set year=?,title=?,subtitle=?,description=?  where sn=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, year);
			ps.setString(2, title);
			ps.setString(3, subtitle);
			ps.setString(4, description);
			
			ps.setInt(5,sn);
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
