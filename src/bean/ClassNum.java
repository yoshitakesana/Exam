package bean;

public class ClassNum implements java.io.Serializable{
	private School school;
	private String class_num;

	public ClassNum() {
	}

	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	// 修正後（EL対応）
	public String getClass_num() {
	    return class_num;
	}
	public void setClass_num(String class_num) {
	    this.class_num = class_num;
	}



}
