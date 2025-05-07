package scoremanager.main;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDao;

	@WebServlet("/subjectlist")
	public class SubjectListAction extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	        try {
	            // DAOを使って科目一覧を取得
	            SubjectDao dao = new SubjectDao();
	            List<Subject> list = dao.findAll(); // 全件取得のみ

	            // 取得結果をリクエストスコープに保存
	            request.setAttribute("list", list); // JSPではこの "list" を使ってループ

	            // JSP に画面遷移
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/subject/subject_list.jsp");
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

