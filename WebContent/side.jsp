<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!-- 外部CSSを読み込む -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">


<!-- 左メニューエリア -->
<div class="menu-container">
<ul class="menu-list">
<li><a href="<%= request.getContextPath() %>/menu.jsp">メニュー</a></li>
<li><a href="<%= request.getContextPath() %>/studentlist">学生管理</a></li>
<li>成績管理</li>
<li><a href="<%= request.getContextPath() %>/testregist">成績登録</a></li>
<li><a href="<c:url value='/main/TestListAction'/>">成績参照</a></li>
<li><a href="<%= request.getContextPath() %>/subjectlist">科目管理</a></li>
</ul>
</div>