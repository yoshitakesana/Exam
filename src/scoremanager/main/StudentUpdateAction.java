package scoremanager.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDao;

@WebServlet("/StudentUpdateAction")
public class StudentUpdateAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // URLのパラメータ名に合わせて修正
        String no = request.getParameter("studentNo");
        String schoolCd = request.getParameter("schoolCd");

        System.out.println("更新対象の学生番号: " + no);
        System.out.println("学校コード: " + schoolCd);

        try {
            StudentDao dao = new StudentDao();

            // schoolCd も渡すように変更
            Student student = dao.findByNo(no, schoolCd);

            if (student != null) {
                request.setAttribute("student", student);
                request.getRequestDispatcher("/student/student_update.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "該当する学生が見つかりませんでした。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "サーバーエラーが発生しました。");
        }
    }
}
