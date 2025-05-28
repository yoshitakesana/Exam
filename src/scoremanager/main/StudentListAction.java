package scoremanager.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDao;

@WebServlet("/studentlist")
public class StudentListAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            // 入力値を取得（nullや空文字を考慮）
            String entYearStr = request.getParameter("entYear");
            String classNum = request.getParameter("classNum");
            String isAttendStr = request.getParameter("isAttend");

            // 型変換（空文字だった場合はnullにする）
            Integer entYear = (entYearStr != null && !entYearStr.isEmpty()) ? Integer.parseInt(entYearStr) : null;
            Boolean isAttend = null;
            if (isAttendStr != null && !isAttendStr.isEmpty()) {
                isAttend = Boolean.parseBoolean(isAttendStr);
            }

            // DAOを使って検索（絞り込み条件がない場合は全件検索を行う）
            StudentDao dao = new StudentDao();
            List<Student> list;

            // 絞り込み条件が全てnullまたは空文字の場合、全件検索を実行
            if (entYear == null && classNum == null && isAttend == null) {
                list = dao.selectAll();  // 全件検索
            } else {
                list = dao.search(entYear, classNum, isAttend);  // 絞り込み検索
            }

         // 検索結果をリクエストスコープに保存
            request.setAttribute("list", list);  // ここを 'studentList' に変更

            // student_list.jspに画面遷移
            RequestDispatcher dispatcher = request.getRequestDispatcher("/student/student_list.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }
}
