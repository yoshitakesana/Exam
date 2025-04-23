package tool;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        execute(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        execute(req, res);
    }

    private void execute(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            // リクエストパラメータから action を取得（例: StudentCreate）
            String actionName = req.getParameter("action");

            // フルクラス名を作成（例: scoremanager.main.StudentCreateAction）
            String className = "scoremanager.main." + actionName + "Action";

            // クラスを読み込んでインスタンス化
            Class<?> clazz = Class.forName(className);
            Action action = (Action) clazz.getDeclaredConstructor().newInstance();

            // execute() を呼び出す
            action.execute(req, res);

        } catch (Exception e) {
            // 例外が発生したらエラー画面に飛ばす or スタックトレース表示
            throw new ServletException(e);
        }
    }
}
