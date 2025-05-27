package scoremanager.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDao;

@WebServlet("/StudentUpdateExecuteAction")
public class StudentUpdateExecuteAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ① パラメータを取得
        request.setCharacterEncoding("UTF-8");
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String entYearStr = request.getParameter("entYear");
        String classNum = request.getParameter("classNum");
        String isAttendStr = request.getParameter("isAttend");

        System.out.println("更新データ: " + no + ", " + name + ", " + entYearStr + ", " + classNum + ", " + isAttendStr);

        try {
            // ② 入学年度をintに変換
            int entYear = Integer.parseInt(entYearStr);

            // ③ 在学中かどうかをbooleanに変換
            boolean isAttend = "true".equals(isAttendStr);

            // ④ Studentオブジェクトにセット
            Student student = new Student();
            student.setNo(no);
            student.setName(name);
            student.setEntYear(entYear);
            student.setClassNum(classNum);
            student.setIsAttend(isAttend);

            // ⑤ DAOのupdateメソッドで更新
            StudentDao dao = new StudentDao();
            dao.update(student);

         // 更新処理のあと
            request.getRequestDispatcher("/student/student_update_done.jsp").forward(request, response);


        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "更新処理でエラーが発生しました。");
        }
    }
}
