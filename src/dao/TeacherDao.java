package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;
public class TeacherDao extends Dao {
    public Teacher authenticate(String id, String password) {
        Teacher teacher = null;
        String sql = "SELECT * FROM teacher WHERE id = ? AND password = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setPassword(rs.getString("password"));
                teacher.setName(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacher;
    }
}
