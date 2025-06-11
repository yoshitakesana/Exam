package scoremanager.main;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ClassNum;
import bean.School;
import bean.Subject;
import dao.ClassNumDao;
import dao.SubjectDao;

@WebServlet("/testlist")  // URLパターンは適宜調整してください
public class TestListAction extends HttpServlet {


    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	HttpSession session = request.getSession(true); // 既存のセッションを取得（新規作成しない）
    	School school = (School) session.getAttribute("school");

    	if (school == null) {
    		getServletContext().log("学校情報がセッションに存在しません");
    		response.sendRedirect("login.jsp");
    		return;
    	}

        try {
            // 現在の年を取得してリクエストスコープへ
            int currentYear = Year.now().getValue();
            request.setAttribute("currentYear", currentYear);

            // 入学年度リストを生成（例：過去5年分）
            List<Integer> yearList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                yearList.add(currentYear - i);
            }
            request.setAttribute("yearList", yearList);

            // 学校IDを取得
            int schoolId = Integer.parseInt(school.getCd());
            getServletContext().log("学校情報:" + school.getName() + "（ID: " + school.getCd() + ")");

            // 所属学校クラス一覧を取得
            ClassNumDao classNumDao = new ClassNumDao();
            List<ClassNum> classList = classNumDao.selectBySchoolId(schoolId);
            request.setAttribute("clssList", classList);

            // 科目一覧を取得
            SubjectDao subjectDao = new SubjectDao();
            List<Subject> subjectList = subjectDao.selectAll();
            request.setAttribute("subjectList", subjectList);


            // JSPへフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("test/test_list.jsp");
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
