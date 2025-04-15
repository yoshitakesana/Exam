package bean;

public class Student implements java.io.Serializable{
	private String no;
	private String name;
	private Integer entyear;
	private String classnum;
	private Boolean isattend;
	private String schoolcd;
	public String getno() {
		return no;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getEntyear() {
		return entyear;
	}
	public void setEntyear(Integer entyear) {
		this.entyear = entyear;
	}
	public String getClassnum() {
		return classnum;
	}
	public void setClassnum(String classnum) {
		this.classnum = classnum;
	}
	public Boolean getIsattend() {
		return isattend;
	}
	public void setIsattend(Boolean isattend) {
		this.isattend = isattend;
	}
	public String getSchoolcd() {
		return schoolcd;
	}
	public void setSchoolcd(String schoolcd) {
		this.schoolcd = schoolcd;
	}








}
