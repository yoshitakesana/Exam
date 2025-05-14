package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class SubjectDao extends Dao {
    // 科目一覧取得
    public List<Subject> findAll() throws Exception {
        List<Subject> list = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT SCHOOL_CD, CD, NAME FROM SUBJECT ORDER BY SCHOOL_CD, CD";

        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Subject subject = new Subject();
            subject.setSchoolCd(rs.getString("SCHOOL_CD"));
            subject.setCd(rs.getString("CD"));
            subject.setName(rs.getString("NAME"));
            list.add(subject);
        }

        st.close();
        con.close();
        return list;
    }

    // 科目の作成
    public void create(Subject subject) throws Exception {
        Connection con = getConnection();
        String sql = "INSERT INTO SUBJECT (SCHOOL_CD, CD, NAME) VALUES (?, ?, ?)";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, "oom");  // SCHOOL_CD の値（例: 'oom'）
        st.setString(2, subject.getCd());
        st.setString(3, subject.getName());

        st.executeUpdate();
        st.close();
        con.close();
    }

    // 科目削除
    public boolean delete(String cd) throws Exception {
        Connection con = getConnection();
        String sql = "DELETE FROM SUBJECT WHERE CD = ?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, cd);

        int rowsDeleted = st.executeUpdate();
        st.close();
        con.close();

        return rowsDeleted > 0;
    }

    // ✅ 科目更新（学校コードは無視する）
    public boolean update(String cd, String name) throws Exception {
        Connection con = getConnection();
        String sql = "UPDATE SUBJECT SET NAME = ? WHERE CD = ?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, name);
        st.setString(2, cd);

        int rowsUpdated = st.executeUpdate();
        st.close();
        con.close();

        return rowsUpdated > 0;
    }

    // ✅ 科目検索（科目コードのみで検索）
    public Subject findByCd(String cd) throws Exception {
        Connection con = getConnection();
        String sql = "SELECT CD, NAME FROM SUBJECT WHERE CD = ?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, cd);

        ResultSet rs = st.executeQuery();

        Subject subject = null;
        if (rs.next()) {
            subject = new Subject();
            subject.setCd(rs.getString("CD"));
            subject.setName(rs.getString("NAME"));
        }

        st.close();
        con.close();
        return subject;
    }
}
