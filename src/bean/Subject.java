package bean;

public class Subject implements java.io.Serializable {
	private String schoolCd;  // 学校コード
    private String cd;        // 科目コード
    private String name;// 科目名

    public String getSchoolCd() {
		return schoolCd;
	}
	public void setSchoolCd(String schoolCd) {
		this.schoolCd = schoolCd;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}


