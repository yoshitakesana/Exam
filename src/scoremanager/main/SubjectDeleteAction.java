package scoremanager.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SubjectDeleteAction")
public class SubjectDeleteAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // JSPから送られてきた科目コードと学校コードを取得
        String cd = request.getParameter("cd");
        String schoolCd = request.getParameter("schoolCd");

        // デバッグ用の出力（削除対象の確認）
        System.out.println("削除対象の科目コード: " + cd);
        System.out.println("削除対象の学校コード: " + schoolCd);

        // リクエストにパラメータをセット
        request.setAttribute("cd", cd);
        request.setAttribute("schoolCd", schoolCd);

        // 削除処理の実行クラスへフォワード
        request.getRequestDispatcher("/SubjectDeleteExecuteAction").forward(request, response);
    }
}
