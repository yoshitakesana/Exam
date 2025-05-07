//科目更新・科目一覧・科目登録・科目削除
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class SubjectDao extends Dao {
	public List<Subject> findAll() throws Exception {
	    List<Subject> list = new ArrayList<>();
	    // DB接続を取得
	    Connection con = getConnection();

	    // SQL文の準備
	    String sql = "SELECT SCHOOL_CD, CD, NAME FROM SUBJECT ORDER BY SCHOOL_CD, CD";

	    // SQLの実行準備
	    PreparedStatement st = con.prepareStatement(sql);
	    ResultSet rs = st.executeQuery();

	    // 結果をリストに詰める
	    while (rs.next()) {
	        Subject subject = new Subject();
	        subject.setSchoolCd(rs.getString("SCHOOL_CD"));
	        subject.setCd(rs.getString("CD"));
	        subject.setName(rs.getString("NAME"));

	        // リストに追加
	        list.add(subject);
	    }

	    // リソース解放
	    st.close();
	    con.close();

	    return list;
	}
	public void create(Subject subject) throws Exception {
        Connection con = getConnection();

        // SQL文の準備（科目コードと科目名をINSERT）
        String sql = "INSERT INTO SUBJECT (SCHOOL_CD, CD, NAME) VALUES (?, ?, ?)";

        // SQLの実行準備
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, "oom");  // SCHOOL_CD の値（例: 'oom'）
        st.setString(2, subject.getCd());  // 受け取った科目コード
        st.setString(3, subject.getName());  // 受け取った科目名

        // SQLの実行
        st.executeUpdate();

        // リソース解放
        st.close();
        con.close();
    }

	}




