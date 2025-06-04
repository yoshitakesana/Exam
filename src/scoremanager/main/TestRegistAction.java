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
import bean.Student;
import bean.Subject;
import dao.ClassNumDao;
import dao.StudentDao;
import dao.SubjectDao;

@WebServlet("/testregist")  // 適宜URLマッピングは調整
public class TestRegistAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int currentYear = Year.now().getValue();
            request.setAttribute("currentYear", currentYear);

            // クラス一覧と科目一覧を取得
            ClassNumDao classDao = new ClassNumDao();
            List<ClassNum> classList = classDao.selectAll();

            SubjectDao subjectDao = new SubjectDao();
            List<Subject> subjectList = subjectDao.selectAll();

            request.setAttribute("classList", classList);
            request.setAttribute("subjectList", subjectList);

            // 検索条件がある場合（フォーム送信後）
            String entYearStr = request.getParameter("entYear");
            String classNum = request.getParameter("classNum");

            if (entYearStr != null && classNum != null && !entYearStr.isEmpty() && !classNum.isEmpty()) {
                int entYear = Integer.parseInt(entYearStr);

                // 学生一覧を取得
                StudentDao studentDao = new StudentDao();
                List<Student> studentList = studentDao.selectByEntYearAndClass(entYear, classNum);
                request.setAttribute("list", studentList);
            }

            // JSPへフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("test/test_regist.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

