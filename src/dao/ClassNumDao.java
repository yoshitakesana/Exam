package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ClassNum;

public class ClassNumDao extends Dao {  // ★ Dao クラスを継承

    // 全クラス取得
    public List<ClassNum> selectAll() throws Exception {
        Connection conn = getConnection(); // Daoクラスから継承したgetConnection()を使用
        String sql = "SELECT DISTINCT class_num FROM student ORDER BY class_num";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<ClassNum> list = new ArrayList<>();
        while (rs.next()) {
            ClassNum c = new ClassNum();
            c.setClass_num(rs.getString("class_num"));
            list.add(c);
        }

        rs.close();
        stmt.close();
        conn.close();
        return list;
    }

    // 入学年度でクラスを絞り込み
    public List<ClassNum> selectByEntYear(int entYear) throws Exception {
        Connection conn = getConnection(); // Daoクラスから継承したgetConnection()を使用
        String sql = "SELECT DISTINCT class_num FROM student WHERE ent_year = ? ORDER BY class_num";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, entYear);
        ResultSet rs = stmt.executeQuery();

        List<ClassNum> list = new ArrayList<>();
        while (rs.next()) {
            ClassNum c = new ClassNum();
            c.setClass_num(rs.getString("class_num"));
            list.add(c);
        }

        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
}
