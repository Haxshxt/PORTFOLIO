package model;

public class ExperiencePojo {

	private int sn;
	private String year;
	private String title;
	private String subtitle;
	private String description;

	public ExperiencePojo(int sn, String year, String title, String subtitle, String description) {
		super();
		this.sn = sn;
		this.year = year;
		this.title = title;
		this.subtitle = subtitle;
		this.description = description;
	}
	@Override
	public String toString() {
		return "ExperiencePojo [sn=" + sn + ", year=" + year + ", title=" + title + ", subtitle=" + subtitle
				+ ", description=" + description + "]";
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
