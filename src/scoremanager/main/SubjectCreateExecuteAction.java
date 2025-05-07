package scoremanager.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDao;

@WebServlet("/SubjectCreateExecuteAction")
public class SubjectCreateExecuteAction extends HttpServlet{
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            // フォームから送信されたデータを受け取る
            String cd = request.getParameter("cd");
            String name = request.getParameter("name");

            // データが空でないか確認する（簡単なバリデーション）
            if (cd == null || cd.isEmpty() || name == null || name.isEmpty()) {
                // エラーがある場合は、フォームに戻してエラーメッセージを表示
                request.setAttribute("error", "科目コードと科目名は必須です。");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/subject/subject_create.jsp");
                dispatcher.forward(request, response);
                return;
            }

            // 受け取ったデータを `Subject` オブジェクトにセット
            Subject subject = new Subject();
            subject.setCd(cd);
            subject.setName(name);

            // `SubjectDao` を使ってデータベースに新しい科目を登録
            SubjectDao dao = new SubjectDao();
            dao.create(subject);

            // 登録が成功したら、科目一覧画面にリダイレクト
            response.sendRedirect("subjectlist");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("科目登録中にエラーが発生しました", e);
        }
    }
}

