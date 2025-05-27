package scoremanager.main;
//おい！
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDao;

@WebServlet("/SubjectDeleteExecuteAction")
public class SubjectDeleteExecuteAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // フォワードされたリクエストから科目コードを取得
        String cd = (String) request.getAttribute("cd");

        try {
            // DAOのインスタンス生成
            SubjectDao subjectDao = new SubjectDao();

            // 削除処理の実行
            boolean isDeleted = subjectDao.delete(cd);

            if (isDeleted) {
                System.out.println("削除成功！");
                // 削除後に科目一覧にリダイレクト
                response.sendRedirect(request.getContextPath() + "/subjectlist");
            } else {
                System.out.println("削除失敗：該当データが見つかりませんでした。");
                request.setAttribute("errorMessage", "削除できませんでした。");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "データベースエラーが発生しました。");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
