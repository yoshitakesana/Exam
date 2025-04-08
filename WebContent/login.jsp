<%@ page import="tool.Page" %>
<%@ page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
    String name = null;

    // JSPのレスポンスから PrintWriter を取得
    PrintWriter pw = response.getWriter();

    Page.header(pw, name);
%>

<h2>ログインページ</h2>
<form method="post" action="login">
    ユーザー名：<input type="text" name="username"><br>
    パスワード：<input type="password" name="password"><br>
    <input type="submit" value="ログイン">
</form>

<%
    Page.footer(pw);
%>
