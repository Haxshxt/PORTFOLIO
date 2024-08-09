package model;

public class ReadAdminLoginPojo {
	
	int sn;
	String username ;
	String password;
	public ReadAdminLoginPojo(int sn, String username, String password) {
		super();
		this.sn = sn;
		this.username = username;
		this.password = password;
	}
	public ReadAdminLoginPojo() {
		
	}
	
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ReadAdminLoginPojo [sn=" + sn + ", username=" + username + ", password=" + password + "]";
	}

}
