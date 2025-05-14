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
        String cd = request.getParameter("cd");
        String name = request.getParameter("name");

        System.out.println("更新する科目コード: " + cd);
        System.out.println("更新後の科目名: " + name);

        try {
            SubjectDao subjectDao = new SubjectDao();
            boolean isUpdated = subjectDao.update(cd, name);

            if (isUpdated) {
                System.out.println("✅ 更新成功");
                response.sendRedirect(request.getContextPath() + "/SubjectListAction");
            } else {
                System.out.println("❌ 更新失敗");
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "科目の更新に失敗しました。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "データベースエラーが発生しました。");
        }
    }
}
