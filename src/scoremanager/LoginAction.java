package scoremanager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDao;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // フォームから ID と パスワード を取得
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        TeacherDao dao = new TeacherDao();
        Teacher teacher = dao.authenticate(id, password);

        // パスワードの確認
        if (teacher != null) {
            // セッションを取得
            HttpSession session = request.getSession(true);
            session.setAttribute("user", teacher);

            // teacher としても保存（既存処理）
            session.setAttribute("teacher", teacher);

            // user としても保存（JSP などで共通的に扱うため）
            session.setAttribute("user", teacher);

            // 学校情報をセット
            if (teacher.getSchool() != null) {
            	session.setAttribute("school", teacher.getSchool());
            } else {
            	getServletContext().log("ログインユーザーに学生情報が設定されていません。");
            }

            // メインページに遷移
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        } else {
            // パスワードやIDが不正の場合、エラーメッセージを表示
            request.setAttribute("errorMessage", "ID または パスワードが不正です");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
