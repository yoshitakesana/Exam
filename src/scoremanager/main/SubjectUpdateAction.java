package scoremanager.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDao;

@WebServlet("/SubjectUpdateAction")
public class SubjectUpdateAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cd = request.getParameter("cd");
        System.out.println("更新対象の科目コード: " + cd);  // ✅ ここで表示されるか確認

        try {
            SubjectDao subjectDao = new SubjectDao();
            Subject subject = subjectDao.findByCd(cd);

            if (subject != null) {
                System.out.println("取得した科目名: " + subject.getName()); // ✅ 科目名が取れているか確認
                request.setAttribute("cd", subject.getCd());
                request.setAttribute("name", subject.getName());
                request.getRequestDispatcher("/subject/subject_update.jsp").forward(request, response);
            } else {
                System.out.println("科目が見つかりませんでした。"); // ✅ ここが出たらデータが存在しない
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "該当する科目が見つかりませんでした。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "データベースエラーが発生しました。");
        }
    }
}
