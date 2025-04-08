<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String userId = (String) session.getAttribute("userId");
%>
<header>
    <h1>学生管理システム</h1>
    <p>
        <% if (userId != null) { %>
            ログイン中：<strong><%= userId %></strong>
        <% } else { %>
            ゲストとして閲覧中
        <% } %>
    </p>
    <hr>
</header>
