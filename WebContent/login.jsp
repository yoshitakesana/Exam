<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp" />

<h2>ログインページ</h2>

<%
    // エラーメッセージがセットされている場合だけ表示
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
    <p style="color: red;"><%= error %></p>
<%
    }
%>

<form method="post" action="login">
    ID：<input type="text" name="userId"><br>
    パスワード：<input type="password" name="password"><br>
    <input type="submit" value="ログイン">
</form>

<jsp:include page="footer.jsp" />
String userId = request.getParameter("userId");
String password = request.getParameter("password");

// 仮のチェック（実際はDBなど）
if ("admin".equals(userId) && "1234".equals(password)) {
    // 成功
    session.setAttribute("userId", userId);
    response.sendRedirect("home.jsp");
} else {
    // 失敗時、エラーをセットして login.jsp に戻す
    request.setAttribute("error", "IDまたはパスワードが違います");
    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
    dispatcher.forward(request, response);
}
