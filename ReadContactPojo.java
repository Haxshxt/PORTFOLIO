package model;

public class ReadContactPojo {

	private int sn;
	private String name;
	private String email;
	private String message;
	private String datetime;
	
	public ReadContactPojo(int sn, String name, String email, String message, String datetime) {
		super();
		this.sn = sn;
		this.name = name;
		this.email = email;
		this.message = message;
		this.datetime = datetime;
	}
	
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	
	@Override
	public String toString() {
		return "ReadContactPojo [sn=" + sn + ", name=" + name + ", email=" + email + ", message=" + message
				+ ", datetime=" + datetime + "]";
	}
	
	
	
}
