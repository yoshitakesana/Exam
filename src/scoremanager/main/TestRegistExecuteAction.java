package scoremanager.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Test;
import dao.TestDao;

@WebServlet("/testregistexecute")
public class TestRegistExecuteAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            String studentNo = request.getParameter("studentNo");
            String subjectCd = request.getParameter("subjectCd");
            int no = Integer.parseInt(request.getParameter("no"));
            int entYear = Integer.parseInt(request.getParameter("entYear"));
            String classNum = request.getParameter("classNum");
            int point = Integer.parseInt(request.getParameter("point"));
            String schoolCd = request.getParameter("schoolCd");

            Test test = new Test();
            test.setStudentNo(studentNo);
            test.setSubjectCd(subjectCd);
            test.setNo(no);
            test.setEntYear(entYear);
            test.setClassNum(classNum);
            test.setPoint(point);
            test.setSchoolCd(schoolCd);

            TestDao dao = new TestDao();
            dao.insertOrUpdate(test);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/test/test_regist_done.jsp");
            dispatcher.forward(request, response);


        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
