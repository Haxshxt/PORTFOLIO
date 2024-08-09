package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.ReadAdminLoginPojo;



public class AdminLoginDaoImpl implements AdminLoginDao {

	   private Connection conn;
	    private PreparedStatement ps;
	    private String result;
	    private String sql;
	    private ResultSet rs;
	@SuppressWarnings("finally")
	@Override
	public String readAdminLogin(String username, String password) {

			try{
				
				Connection conn = ConnectionFactory.getConnection();
				
				sql="select * from myPortfolio.adminlogin where username =? and password =?";
				ps= conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
			    rs=ps.executeQuery();
				
			    if(rs.next()) {
			    	result="exists";
			    }else {
			    	result="not exists";
			    }
				
			}catch(Exception e){
				e.printStackTrace();
				result="something went wrong";
			}finally {
				return result;
			}
		
	}
	@Override
	public ReadAdminLoginPojo readAdminLoginData() {
		 ReadAdminLoginPojo readAdminLoginPojo = null;
		 try {
		        Connection conn = ConnectionFactory.getConnection();
		        sql = "select * from myPortfolio.adminlogin";
		        ps = conn.prepareStatement(sql);
		        rs = ps.executeQuery();

		        // Check if there is at least one row in the result set
		        if (rs.next()) {
		            // Move the cursor to the first row and retrieve data
		            readAdminLoginPojo = new ReadAdminLoginPojo(rs.getInt("sn"), rs.getString("username"), rs.getString("password"));
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
			
		}
		return readAdminLoginPojo;
	}
	@SuppressWarnings("finally")
	@Override
	public String updateAdminLoginDetails(String sn, String username, String password) {
		try{
			
			Connection conn = ConnectionFactory.getConnection();
			int snn = Integer.parseInt(sn);
			sql = "UPDATE myPortfolio.adminlogin SET username=?, password=? WHERE sn=?";
			ps= conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, snn);
		    int row=ps.executeUpdate();
			
		   if(row==1) {
			   result="updated";
		   }else {
			   result="not updated";
		   }
			
		}catch(Exception e){
			e.printStackTrace();
			result="something went wrong";
		}finally {
			return result;
		}
	}
	
	

}
