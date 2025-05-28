package scoremanager.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TestListStudent;
import dao.TestDao;

@WebServlet("/TestListAction")
public class TestListAction extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int entYear = Integer.parseInt(request.getParameter("entYear"));
            String classNum = request.getParameter("classNum");
            String subjectCd = request.getParameter("subjectCd");
            int times = Integer.parseInt(request.getParameter("times"));

            // 学生一覧を取得（DAOを使う）
            TestDao testDao = new TestDao();
            List<TestListStudent> studentList = testDao.searchStudentsForScoreInput(entYear, classNum);

            // 検索条件も渡す
            request.setAttribute("entYear", entYear);
            request.setAttribute("classNum", classNum);
            request.setAttribute("subjectCd", subjectCd);
            request.setAttribute("times", times);
            request.setAttribute("studentList", studentList);

            RequestDispatcher rd = request.getRequestDispatcher("/test/test_regist_input.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}