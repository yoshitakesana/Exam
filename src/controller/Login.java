package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // フォームから ID と パスワード を取得
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        // セッションに保存（後でヘッダーなどで表示できるように）
        HttpSession session = request.getSession();
        session.setAttribute("userId", userId);

        // パスワードの確認（簡易的な例としてそのまま遷移）
        // ※ここでパスワードを実際に確認するロジックが必要です
        if (userId != null && password != null) {
            // 本来はここでパスワードのチェックなどが入ります
            // 例: if (isValidUser(userId, password)) { ... }

            // メインページに遷移
            request.getRequestDispatcher("/main.jsp").forward(request, response);
        } else {
            // パスワードやIDが不正の場合、エラーメッセージを表示（例）
            request.setAttribute("errorMessage", "ID または パスワードが不正です");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
