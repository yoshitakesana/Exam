package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import bean.TestListStudent;

public class TestDao extends Dao {

    public List<TestListStudent> searchScores(int entYear, String classNum, String subjectCd, int times) throws Exception {
        List<TestListStudent> resultList = new ArrayList<>();

        Connection con = getConnection();

        // SQL文（条件に合う成績を学生情報と結合して取得）
        String sql = "SELECT s.NO AS studentNo, s.NAME AS studentName, s.ENT_YEAR, s.CLASS_NUM, t.POINT " +
                     "FROM STUDENT s JOIN TEST t ON s.NO = t.STUDENT_NO " +
                     "WHERE s.ENT_YEAR = ? AND s.CLASS_NUM = ? AND t.SUBJECT_CD = ? AND t.NO = ? " +
                     "ORDER BY s.NO";

        PreparedStatement st = con.prepareStatement(sql);

        int idx = 1;
        st.setInt(idx++, entYear);
        st.setString(idx++, classNum);
        st.setString(idx++, subjectCd);
        st.setInt(idx++, times);

        ResultSet rs = st.executeQuery();

        // 学生ごとにまとめるためMapを用意
        Map<String, TestListStudent> studentMap = new LinkedHashMap<>();

        while (rs.next()) {
            String no = rs.getString("studentNo");
            TestListStudent tls = studentMap.get(no);

            if (tls == null) {
                tls = new TestListStudent();
                tls.setStudentNo(no);
                tls.setStudentName(rs.getString("studentName"));
                tls.setEntYear(rs.getInt("ENT_YEAR"));
                tls.setClassNum(rs.getString("CLASS_NUM"));
                tls.setPoints(new HashMap<>());
                studentMap.put(no, tls);
            }
            tls.getPoints().put(times, rs.getInt("POINT"));
        }

        rs.close();
        st.close();
        con.close();

        resultList.addAll(studentMap.values());

        return resultList;
    }
}
