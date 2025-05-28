package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.Teacher;
import bean.Test;

public class TestDao extends Dao {

    /**

     * 現在の西暦（年）を返すメソッド

     */

    public int getCurrentYear() {

        return java.time.Year.now().getValue();

    }

    /**

     * 指定した条件（入学年度、クラス、科目コード、回数）で成績情報を検索する

     *

     * @param entYear 入学年度

     * @param classNum クラス

     * @param subjectCd 科目コード

     * @param testCount テスト回数

     * @return 該当する成績情報のリスト

     * @throws Exception

     */

    public List<Test> search(Integer entYear, String classNum, String subjectCd, Integer testCount) throws Exception {

        List<Test> list = new ArrayList<>();

        Connection con = getConnection();

        // ベースSQL。JOINで学生情報や科目情報を取る形にしてもよいですが、まずは単純にTestテーブルだけの想定で。

        String sql = "SELECT * FROM TEST WHERE 1=1";

        if (entYear != null) {

            sql += " AND ENT_YEAR = ?";

        }

        if (classNum != null && !classNum.isEmpty()) {

            sql += " AND CLASS_NUM = ?";

        }

        if (subjectCd != null && !subjectCd.isEmpty()) {

            sql += " AND SUBJECT_CD = ?";

        }

        if (testCount != null) {

            sql += " AND TEST_COUNT = ?";

        }

        PreparedStatement st = con.prepareStatement(sql);

        int idx = 1;

        if (entYear != null) {

            st.setInt(idx++, entYear);

        }

        if (classNum != null && !classNum.isEmpty()) {

            st.setString(idx++, classNum);

        }

        if (subjectCd != null && !subjectCd.isEmpty()) {

            st.setString(idx++, subjectCd);

        }

        if (testCount != null) {

            st.setInt(idx++, testCount);

        }

        ResultSet rs = st.executeQuery();

        while (rs.next()) {

            Test test = new Test();
            Teacher teacher=new Teacher();
            Student student=new Student();


            teacher.setId(rs.getString("ID"));  // プライマリキーなどあれば

            student.setEntYear(rs.getInt("ENT_YEAR"));

            test.setClassNum(rs.getString("CLASS_NUM"));

            student.setno(rs.getString("STUDENT_NO"));

            test.setSubjectCd(rs.getString("SUBJECT_CD"));

            test.setTestCount(rs.getInt("TEST_COUNT"));

            test.setScore(rs.getInt("SCORE"));  // 点数

            list.add(test);

        }

        st.close();

        con.close();

        return list;

    }

    /**

     * 成績を登録（INSERT）または更新（UPDATE）するメソッド

     * ここでは単純にINSERTを例示（重複はUPDATEに変更など）

     */

    public void save(Test test) throws Exception {

        Connection con = getConnection();

        // まず既存レコードがあるかチェック（UPDATEかINSERTか判定）

        String checkSql = "SELECT COUNT(*) FROM TEST WHERE STUDENT_NO = ? AND SUBJECT_CD = ? AND TEST_COUNT = ?";

        PreparedStatement checkSt = con.prepareStatement(checkSql);

        checkSt.setString(1, test.getStudentNo());

        checkSt.setString(2, test.getSubjectCd());

        checkSt.setInt(3, test.getTestCount());

        ResultSet rs = checkSt.executeQuery();

        boolean exists = false;

        if (rs.next()) {

            exists = rs.getInt(1) > 0;

        }

        checkSt.close();

        if (exists) {

            // UPDATE文

            String updateSql = "UPDATE TEST SET SCORE = ? WHERE STUDENT_NO = ? AND SUBJECT_CD = ? AND TEST_COUNT = ?";

            PreparedStatement updateSt = con.prepareStatement(updateSql);

            updateSt.setInt(1, test.getScore());

            updateSt.setString(2, test.getStudentNo());

            updateSt.setString(3, test.getSubjectCd());

            updateSt.setInt(4, test.getTestCount());

            updateSt.executeUpdate();

            updateSt.close();

        } else {

            // INSERT文

            String insertSql = "INSERT INTO TEST (ENT_YEAR, CLASS_NUM, STUDENT_NO, SUBJECT_CD, TEST_COUNT, SCORE) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement insertSt = con.prepareStatement(insertSql);

            insertSt.setInt(1, test.getEntYear());

            insertSt.setString(2, test.getClassNum());

            insertSt.setString(3, test.getStudentNo());

            insertSt.setString(4, test.getSubjectCd());

            insertSt.setInt(5, test.getTestCount());

            insertSt.setInt(6, test.getScore());

            insertSt.executeUpdate();

            insertSt.close();

        }

        con.close();

    }

}

