package dao;

import java.sql.ResultSet;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDao extends Dao {
	private String baseSql = "";
	
	public Student get(String no) throws Exception {
		// 学生番号で学生情報取得
		
	}
	private List<Student> postFilter(ResultSet rSet, School school) throws Exception {
	    // ResultSetとSchoolオブジェクトを使って
		// フィルタリング後の学生リストを生成する
	}
	public List<Student> filter(School school, int entYear, String classNum, boolean isAttend) throws Exception {
	    // 学校、入学年、クラス番号、出席状況でフィルタリング
	}

	public List<Student> filter(School school, int entYear, boolean isAttend) throws Exception {
		// 学校、入学年度、出席情報でフィルタリング
	}

	public List<Student> filter(School school, boolean isAttend) throws Exception {
	    // 学校、出席状況でフィルタリング
	}
	public boolean save(Student student) throws Exception {
	    // 学生情報をデータベースに保存するメソッド
	}


}