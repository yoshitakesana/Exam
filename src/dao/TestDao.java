package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import bean.Test;
import bean.TestListStudent;

public class TestDao extends Dao {

    public List<TestListStudent> searchScores(int entYear, String classNum, String subjectCd, int no) throws Exception {
        List<TestListStudent> resultList = new ArrayList<>();

        try (Connection con = getConnection()) {
            String sql = "SELECT s.NO AS studentNo, s.NAME AS studentName, s.ENT_YEAR, s.CLASS_NUM, t.POINT " +
                         "FROM STUDENT s JOIN TEST t ON s.NO = t.STUDENT_NO " +
                         "WHERE s.ENT_YEAR = ? AND s.CLASS_NUM = ? AND t.SUBJECT_CD = ? AND t.NO = ? " +
                         "ORDER BY s.NO";

            try (PreparedStatement st = con.prepareStatement(sql)) {
                int idx = 1;
                st.setInt(idx++, entYear);
                st.setString(idx++, classNum);
                st.setString(idx++, subjectCd);
                st.setInt(idx++, no);

                try (ResultSet rs = st.executeQuery()) {
                    Map<String, TestListStudent> studentMap = new LinkedHashMap<>();

                    while (rs.next()) {
                        String studentNo = rs.getString("studentNo");
                        TestListStudent tls = studentMap.get(studentNo);

                        if (tls == null) {
                            tls = new TestListStudent();
                            tls.setStudentNo(studentNo);
                            tls.setStudentName(rs.getString("studentName"));
                            tls.setEntYear(rs.getInt("ENT_YEAR"));
                            tls.setClassNum(rs.getString("CLASS_NUM"));
                            tls.setPoints(new LinkedHashMap<>());
                            studentMap.put(studentNo, tls);
                        }
                        tls.getPoints().put(no, rs.getInt("POINT"));
                    }

                    resultList.addAll(studentMap.values());
                }
            }
        }
        return resultList;
    }

    // insertまたはupdateを行うメソッド
    public void insertOrUpdate(Test test) throws Exception {
        try (Connection con = getConnection()) {
            // 成績が既に存在するか確認
            String checkSql = "SELECT COUNT(*) FROM TEST WHERE student_no = ? AND subject_cd = ? AND no = ?";
            try (PreparedStatement ps = con.prepareStatement(checkSql)) {
                ps.setString(1, test.getStudentNo());
                ps.setString(2, test.getSubjectCd());
                ps.setInt(3, test.getNo());

                try (ResultSet rs = ps.executeQuery()) {
                    boolean exists = false;
                    if (rs.next() && rs.getInt(1) > 0) {
                        exists = true;
                    }

                    if (exists) {
                        // 更新
                        String updateSql = "UPDATE TEST SET point = ?, class_num = ?, school_cd = ? WHERE student_no = ? AND subject_cd = ? AND no = ?";
                        try (PreparedStatement psUpdate = con.prepareStatement(updateSql)) {
                            psUpdate.setInt(1, test.getPoint());
                            psUpdate.setString(2, test.getClassNum());
                            psUpdate.setString(3, test.getSchoolCd());
                            psUpdate.setString(4, test.getStudentNo());
                            psUpdate.setString(5, test.getSubjectCd());
                            psUpdate.setInt(6, test.getNo());
                            psUpdate.executeUpdate();
                        }
                    } else {
                        // 挿入（ent_year を外す）
                        String insertSql = "INSERT INTO TEST (student_no, subject_cd, no, class_num, point, school_cd) VALUES (?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement psInsert = con.prepareStatement(insertSql)) {
                            psInsert.setString(1, test.getStudentNo());
                            psInsert.setString(2, test.getSubjectCd());
                            psInsert.setInt(3, test.getNo());
                            psInsert.setString(4, test.getClassNum());
                            psInsert.setInt(5, test.getPoint());
                            psInsert.setString(6, test.getSchoolCd());
                            psInsert.executeUpdate();
                        }
                    }
                }
            }
        }
    }

}
