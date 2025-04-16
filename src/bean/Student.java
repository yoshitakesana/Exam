package bean;

public class Student implements java.io.Serializable{
	private String no;
	private String name;
	private Integer entYear;
	private String classNum;
	private Boolean isAttend;
	private School school;

	public Student() {
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
	public Integer getEntYear() {
		return entYear;
	}
	public void setEntYear(Integer entYear) {
		this.entYear = entYear;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	public Boolean isAttend() {
		return isAttend;
	}
	public void setAttend(Boolean isAttend) {
		this.isAttend = isAttend;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}








}
