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

        // フォームから ID を取得
        String userId = request.getParameter("userId");

        // セッションに保存（後でヘッダーなどで表示できるように）
        HttpSession session = request.getSession();
        session.setAttribute("userId", userId);

        // メインページに遷移
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
