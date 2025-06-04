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
import bean.Subject;
import bean.User;
import dao.ClassNumDao;
import dao.SubjectDao;

@WebServlet("/testlist")  // URLパターンは適宜調整してください
public class TestListAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    		// セッションからユーザー情報を取得
    		HttpSession session = request.getSession();
    		User user = (User) session.getAttribute("user");

    		if (user == null){
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


            // 所属学校クラス一覧を取得
            int schoolId = user.getSchool().getSchool_id(); // UserクラスのgetSchoolId()
            ClassNumDao classDao = new ClassNumDao();
            List<ClassNum> classList = classDao.selectBySchoolId(schoolId);
            request.setAttribute("classList", classList);

            // 科目一覧を取得
            SubjectDao subjectDao = new SubjectDao();
            List<Subject> subjectList = subjectDao.selectAll();
            request.setAttribute("subjectList", subjectList);

            // リクエストスコープにセット
            request.setAttribute("classList", classList);
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
