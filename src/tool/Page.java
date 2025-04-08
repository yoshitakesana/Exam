package tool;

import java.io.PrintWriter;

public class Page {

    public static void header(PrintWriter out, String name) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Servlet/JSP Sample Programs</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>得点管理システム</h1>");

        // ヘッダー右上にユーザー名とログアウトリンク
        out.println("<div style='text-align: right;'>");
        if (name != null && !name.isEmpty()) {
            out.println("<span>" + name + " 様</span> | ");
            out.println("<a href='logout'>ログアウト</a>");
        } else {
            out.println("<a href='login.html'>ログイン</a>");
        }
        out.println("</div>");

        out.println("<hr>"); // 区切り線
    }

    public static void footer(PrintWriter out) {
        out.println("<hr>");
        out.println("<footer style='text-align: center;'>");
        out.println("&copy; 2023 TIC | 大原学園");
        out.println("</footer>");
        out.println("</body>");
        out.println("</html>");
    }
}
