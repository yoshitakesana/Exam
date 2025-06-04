package dao;
//学生一覧・学生登録・学生削除

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class StudentDao extends Dao{

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

	public List<Student> selectAll() throws Exception {
	    List<Student> list = new ArrayList<>();
	    Connection con = getConnection();

	    PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENT");
	    ResultSet rs = st.executeQuery();

	    while (rs.next()) {
	        Student stu = new Student();
	        stu.setNo(rs.getString("NO"));              // 学籍番号
	        stu.setName(rs.getString("NAME"));          // 名前
	        stu.setEntYear(rs.getInt("ENT_YEAR"));      // 入学年度
	        stu.setClassNum(rs.getString("CLASS_NUM")); // クラス
	        stu.setAttend(rs.getBoolean("IS_ATTEND"));  // 在学か否か
	        stu.setSchoolCd(rs.getString("SCHOOL_CD")); // 学校コード
	        list.add(stu);
	    }


	    st.close();
	    con.close();

	    return list;
	}

	public void create(Student student) throws Exception {
        Connection con = getConnection();

        // SQL文の準備（入学年度・学生番号・学生名。クラス番号をINSERT）
        String sql = "INSERT INTO STUDENT (NO, NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD) VALUES (?, ?, ?, ?, ?, ?)";

        // SQLの実行準備
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, student.getNo());
        st.setString(2, student.getName());
        st.setInt(3, student.getEntYear());
        st.setString(4, student.getClassNum());

        // 🔹 IS_ATTEND は新規登録時は常に「在学中（true）」にする
        st.setBoolean(5, true);

        // 🔹 SCHOOL_CD は固定値を設定する（例："oom"）
        st.setString(6, "oom");

        // SQLの実行
        st.executeUpdate();

        // リソース解放
        st.close();
        con.close();
	}

	// 学生番号と学校コードで1件取得
	public Student findByNo(String no, String schoolCd) throws Exception {
	    Student student = null;

	    String sql = "SELECT * FROM STUDENT WHERE NO = ? AND SCHOOL_CD = ?";

	    Connection con = getConnection();
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        pstmt.setString(1, no);
	        pstmt.setString(2, schoolCd);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            student = new Student();
	            student.setNo(rs.getString("NO"));
	            student.setName(rs.getString("NAME"));
	            student.setEntYear(rs.getInt("ENT_YEAR"));  // ← ENTYEAR → ENT_YEAR に直しましょう
	            student.setClassNum(rs.getString("CLASS_NUM"));
	            student.setIsAttend(rs.getBoolean("IS_ATTEND"));
	            student.setSchoolCd(rs.getString("SCHOOL_CD"));
	        }

	    } finally {
	        con.close();
	    }

	    return student;
	}

    // 学生情報の更新
    public void update(Student student) throws Exception {
        String sql = "UPDATE STUDENT SET NAME = ?, CLASS_NUM = ?, ENT_YEAR = ?, IS_ATTEND = ? WHERE NO = ?";

        Connection con = getConnection();  // ← ここも getConnection()
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getClassNum());
            pstmt.setInt(3, student.getEntYear());
            pstmt.setBoolean(4, student.getIsAttend());
            pstmt.setString(5, student.getNo());

            pstmt.executeUpdate();

        } finally {
            con.close();  // 接続を閉じる
        }
    }

 // entYear と classNum で学生を検索する
    public List<Student> selectByEntYearAndClass(int entYear, String classNum) throws Exception {
        Connection conn = getConnection();
        String sql = "SELECT * FROM student WHERE ent_year = ? AND class_num = ? ORDER BY no";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, entYear);
        stmt.setString(2, classNum);
        ResultSet rs = stmt.executeQuery();

        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            Student s = new Student();
            s.setNo(rs.getString("no"));
            s.setName(rs.getString("name"));
            s.setEntYear(rs.getInt("ent_year"));
            s.setClassNum(rs.getString("class_num"));
            // 必要ならその他の項目も設定
            list.add(s);
        }

        rs.close();
        stmt.close();
        conn.close();
        return list;
    }

		}














