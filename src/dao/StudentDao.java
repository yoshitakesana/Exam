package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
<<<<<<< HEAD
import java.util.*;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> branch 'master' of https://github.com/yoshitakesana/Exam.git

import bean.Student;

<<<<<<< HEAD
public class StudentDao extends Dao {
	private String baseSql = "select * from student where school_cd = ?";

	public Student get(String no) throws Exception {
		// 学生番号で学生情報取得

	}
	private List<Student> postFilter(ResultSet rSet, School school) throws Exception {
	    // ResultSetとSchoolオブジェクトを使って
		// フィルタリング後の学生リストを生成する
		List<Student> list = new ArrayList<>();
		try {
		}
	}
	public List<Student> filter(School school, int entYear, String classNum, boolean isAttend) throws Exception {
	    // 学校、入学年、クラス番号、出席状況でフィルタリング
	}
=======
public class StudentDao extends Dao{
>>>>>>> branch 'master' of https://github.com/yoshitakesana/Exam.git

	/* 🔍 生徒の条件別絞り込みメソッド*/
	/* 🔍 絞り込みをしない場合は全部のデータが出力される*/


	public List<Student> search(Integer entYear, String classNum, Boolean isAttend) throws Exception {
	    // ① 検索結果を格納するリストを作成
	    List<Student> list = new ArrayList<>();

	    // ② データベース接続を取得（DAOクラスの getConnection() を利用）
	    Connection con = getConnection();

	    // ③ ベースとなるSQL文の準備（WHERE 1=1 にしておくと後からANDを付けやすい）
	    String sql = "SELECT * FROM STUDENT WHERE 1=1";

	    // ④ 検索条件が指定されていればSQLに条件を追加
	    if (entYear != null) {
	        sql += " AND ENT_YEAR = ?";
	    }
	    if (classNum != null && !classNum.isEmpty()) {
	        sql += " AND CLASS_NUM = ?";
	    }
	    if (isAttend != null) {
	        sql += " AND IS_ATTEND = ?";
	    }

	    // ⑤ SQL文をプリコンパイル（プレースホルダ付きのSQLを使えるようにする）
	    PreparedStatement st = con.prepareStatement(sql);

	    // ⑥ プレースホルダ `?` に実際の値を順番にセット
	    int idx = 1;
	    if (entYear != null) {
	        st.setInt(idx++, entYear);  // 入学年度をセット
	    }
	    if (classNum != null && !classNum.isEmpty()) {
	        st.setString(idx++, classNum);  // クラス番号をセット
	    }
	    if (isAttend != null) {
	        st.setBoolean(idx++, isAttend);  // 在学中か否かをセット
	    }

	    // ⑦ SQL文を実行し、検索結果を取得
	    ResultSet rs = st.executeQuery();

	    // ⑧ 検索結果を1件ずつ Student オブジェクトに変換してリストに追加
	    while (rs.next()) {
	        Student s = new Student();
	        s.setNo(rs.getString("NO"));             // 学籍番号を設定
	        s.setName(rs.getString("NAME"));         // 名前を設定
	        s.setEntYear(rs.getInt("ENT_YEAR"));     // 入学年度を設定
	        s.setClassNum(rs.getString("CLASS_NUM")); // クラス番号を設定
	        s.setAttend(rs.getBoolean("IS_ATTEND")); // 在学中かを設定
	        list.add(s);  // 作成したオブジェクトをリストに追加
	    }

	    // ⑨ 使用したリソースを解放（PreparedStatement と Connection を閉じる）
	    st.close();
	    con.close();

	    // ⑩ 検索結果のリストを呼び出し元に返す
	    return list;
	}



	}

