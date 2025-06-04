//成績参照 まだ一ミリもできていない
package scoremanager.main;

import java.io.IOException;
import java.time.Year;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClassNum;
import bean.Subject;
import dao.ClassNumDao;
import dao.SubjectDao;

@WebServlet("/testlist")  // URLパターンは適宜調整してください
public class TestListAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 現在の年を取得してリクエストスコープへ
            int currentYear = Year.now().getValue();
            request.setAttribute("currentYear", currentYear);

            // クラス一覧を取得
            ClassNumDao classDao = new ClassNumDao();
            List<ClassNum> classList = classDao.selectAll();

            // 科目一覧を取得
            SubjectDao subjectDao = new SubjectDao();
            List<Subject> subjectList = subjectDao.selectAll();

            // リクエストスコープにセット
            request.setAttribute("classList", classList);
            request.setAttribute("subjectList", subjectList);

            // JSPへフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("test/test_regist.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
