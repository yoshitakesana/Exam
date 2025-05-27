package scoremanager.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDao;

@WebServlet("/SubjectUpdateExecuteAction")
public class SubjectUpdateExecuteAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータからデータを取得
        String cd = request.getParameter("cd");
        String name = request.getParameter("name");

        System.out.println("更新対象の科目コード: " + cd);
        System.out.println("新しい科目名: " + name);

        try {
            SubjectDao subjectDao = new SubjectDao();
            boolean isUpdated = subjectDao.update(cd, name);

            if (isUpdated) {
                // 更新成功した場合、完了画面に遷移
                response.sendRedirect(request.getContextPath() + "/subject/subject_update_done.jsp");
            } else {
                // 更新失敗した場合、エラーメッセージを表示
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "科目の更新に失敗しました。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "データベースエラーが発生しました。");
        }
    }
}
