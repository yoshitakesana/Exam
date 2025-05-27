package scoremanager.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentCreateAction")
public class StudentCreateAction extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException {

		    // 🔹 今年の西暦を取得
		    int currentYear = Calendar.getInstance().get(Calendar.YEAR);

		    // 🔹 10年前から10年後までのリストを生成
		    List<Integer> yearList = new ArrayList<>();
		    for (int i = currentYear - 10; i <= currentYear + 10; i++) {
		        yearList.add(i);
		    }




		    // 🔹 JSPにリストを渡す
		    request.setAttribute("yearList", yearList);

		    // JSP（登録フォーム）へフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/student/student_create.jsp");
		    dispatcher.forward(request, response);
	 }
}
