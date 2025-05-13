package scoremanager.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDao;

@WebServlet("/StudentCreateExecuteAction")
public class StudentCreateExecuteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	        try {
	            // フォームから送信されたデータを受け取る
	            String no = request.getParameter("no"); // 学生番号
	            String name = request.getParameter("name"); // 学生名
	            String entYearStr = request.getParameter("entYear"); // 入学年度
	            String classNum = request.getParameter("classNum"); // クラス番号

	         // データが空でないか確認する（簡単なバリデーション）
	            if (no == null || no.isEmpty() || name == null || name.isEmpty() ||
	                entYearStr == null || entYearStr.isEmpty() || classNum == null || classNum.isEmpty()) {

	            	// エラーがある場合は、フォームに戻してエラーメッセージを表示
	                request.setAttribute("error", "全ての項目は必須です。");
	                RequestDispatcher dispatcher = request.getRequestDispatcher("/student/student_create.jsp");
	                dispatcher.forward(request, response);
	                return;
	            }

	         // 入学年度を Integer に変換
	            int entYear;
	            try {
	                entYear = Integer.parseInt(entYearStr);
	            } catch (NumberFormatException e) {
	                request.setAttribute("error", "入学年度は数字で入力してください。");
	                RequestDispatcher dispatcher = request.getRequestDispatcher("/student/student_create.jsp");
	                dispatcher.forward(request, response);
	                return;
	            }

	         // 受け取ったデータを `Student` オブジェクトにセット
	            Student student = new Student();
	            student.setNo(no);
	            student.setName(name);
	            student.setEntYear(entYear);
	            student.setClassNum(classNum);

	         // 🔹 追加：在学中フラグをセット (true)
		        student.setIsAttend(true);

		        // 🔹 追加：学校コードをセット ("oom")
		        student.setSchoolCd("oom");

	            // `StudentDao` を使ってデータベースに新しい学生を登録
	            StudentDao dao = new StudentDao();
	            dao.create(student);

	            // ✅ 登録が成功したら、完了画面にフォワード
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/student/student_create_done.jsp");
	            dispatcher.forward(request, response);

	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new ServletException("学生登録中にエラーが発生しました", e);
	        }
	    }
	}