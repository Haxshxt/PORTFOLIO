package model;

public class EducationPojo {

	private int sn;
	private String year;
	private String title;
	private String subtitle;
	private String description;
	private String datetime;
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public EducationPojo(int sn, String year, String title, String subtitle, String description, String datetime) {
		super();
		this.sn = sn;
		this.year = year;
		this.title = title;
		this.subtitle = subtitle;
		this.description = description;
		this.datetime = datetime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "EducationPojo [sn=" + sn + ", year=" + year + ", title=" + title + ", subtitle=" + subtitle
				+ ", description=" + description + ", datetime=" + datetime + "]";
	}
	
	
}
