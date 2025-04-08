<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String userName = (String) session.getAttribute("userName");
%>
<header style="background-color: #a3c9e2; padding: 10px;">
    <h1>学生管理システム</h1>
    <p>ログイン中：<%= userName != null ? userName : "様" %></p>
</header>
