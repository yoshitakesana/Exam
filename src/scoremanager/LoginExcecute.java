package scoremanager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import dao.TeacherDao;


@WebServlet("/LoginExcecute")
public class LoginExcecute extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// TeacherDaoを使用して認証
		TeacherDao dao = new TeacherDao();
		Teacher teacher = dao.authenticate(id, password);

		if (teacher != null) {
			request.getSession().setAttribute("teacher", teacher);
			response.sendRedirect("menu.jsp");
		} else {
			request.setAttribute("error", "invalid");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
