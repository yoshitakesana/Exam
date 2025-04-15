package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class StudentDAO extends DAO {

    // 🔍 名前で部分一致検索
    public List<Student> search(String keyword) throws Exception {
        List<Student> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENT WHERE NAME LIKE ?");
        st.setString(1, "%" + keyword + "%");

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Student student = mapResultSetToStudent(rs);
            list.add(student);
        }

        rs.close();
        st.close();
        con.close();

        return list;
    }

    // ➕ 学生追加
    public int insert(Student student) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
            "INSERT INTO STUDENT (NO, NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD) VALUES (?, ?, ?, ?, ?, ?)"
        );
        st.setString(1, student.getNo());
        st.setString(2, student.getName());
        st.setObject(3, student.getEntyear(), java.sql.Types.INTEGER);
        st.setString(4, student.getClassnum());
        st.setObject(5, student.getIsattend(), java.sql.Types.BOOLEAN);
        st.setString(6, student.getSchoolcd());

        int rowsAffected = st.executeUpdate();

        st.close();
        con.close();

        return rowsAffected;
    }

    // 🔎 主キーで検索
    public Student findByNo(String no) throws Exception {
        Student student = null;
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENT WHERE NO = ?");
        st.setString(1, no);

        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            student = mapResultSetToStudent(rs);
        }

        rs.close();
        st.close();
        con.close();

        return student;
    }

    // 🔁 学生情報を更新（主キー指定）
    public int update(Student student) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
            "UPDATE STUDENT SET NAME = ?, ENT_YEAR = ?, CLASS_NUM = ?, IS_ATTEND = ?, SCHOOL_CD = ? WHERE NO = ?"
        );
        st.setString(1, student.getName());
        st.setObject(2, student.getEntyear(), java.sql.Types.INTEGER);
        st.setString(3, student.getClassnum());
        st.setObject(4, student.getIsattend(), java.sql.Types.BOOLEAN);
        st.setString(5, student.getSchoolcd());
        st.setString(6, student.getNo());

        int rowsAffected = st.executeUpdate();

        st.close();
        con.close();

        return rowsAffected;
    }

    // ❌ 学生削除（主キー指定）
    public int delete(String no) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("DELETE FROM STUDENT WHERE NO = ?");
        st.setString(1, no);

        int rowsAffected = st.executeUpdate();

        st.close();
        con.close();

        return rowsAffected;
    }

    // 📋 全件取得
    public List<Student> findAll() throws Exception {
        List<Student> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENT ORDER BY NO");

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Student student = mapResultSetToStudent(rs);
            list.add(student);
        }

        rs.close();
        st.close();
        con.close();

        return list;
    }

    // 🎯 ResultSet → Student Bean 変換（共通処理）
    private Student mapResultSetToStudent(ResultSet rs) throws Exception {
        Student student = new Student();
        student.setNo(rs.getString("NO"));
        student.setName(rs.getString("NAME"));
        student.setEntyear((Integer) rs.getObject("ENT_YEAR")); // NULL考慮
        student.setClassnum(rs.getString("CLASS_NUM"));
        student.setIsattend((Boolean) rs.getObject("IS_ATTEND")); // NULL考慮
        student.setSchoolcd(rs.getString("SCHOOL_CD"));
        return student;
    }
}
