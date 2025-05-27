package scoremanager.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SubjectCreateAction")
public class SubjectCreateAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // JSP（登録フォーム）へフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/subject/subject_create.jsp");
        dispatcher.forward(request, response);
    }
}
