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
        	// セッションに保存（後でヘッダーなどで表示できるように）
        	HttpSession session = request.getSession();
        	session.setAttribute("teacher", teacher);

            // メインページに遷移
            request.getRequestDispatcher("menu.jsp").forward(request, response);;
        } else {
            // パスワードやIDが不正の場合、エラーメッセージを表示（例）
            request.setAttribute("errorMessage", "ID または パスワードが不正です");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
