<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    Object user = session.getAttribute("user");
    if (user != null) {
%>

<ul>
  <li><a href="#">メニュー</a></li>
  <li><a href="#">学生管理</a></li>

  <li>成績管理
    <ul style="margin-left: 20px;">
      <li><a href="#">成績登録</a></li>
      <li><a href="#">成績参照</a></li>
    </ul>
  </li>

  <li><a href="#">科目管理</a></li>
</ul>
<%
    }
%>