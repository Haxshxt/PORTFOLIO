package model;

public class UploadProjectPojo {

	private int sn;
	private String formatedFilename;
	private String datetime;
	
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getFormatedFilename() {
		return formatedFilename;
	}
	public void setFormatedFilename(String formatedFilename) {
		this.formatedFilename = formatedFilename;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "UploadProjectPojo [sn=" + sn + ", formatedFilename=" + formatedFilename + ", datetime=" + datetime
				+ "]";
	}
	public UploadProjectPojo(int sn, String formatedFilename, String datetime) {
		super();
		this.sn = sn;
		this.formatedFilename = formatedFilename;
		this.datetime = datetime;
	}
	
}
