<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

 <%-- タイトル + CSS --%>

<!-- メニューとコンテンツを横並びに配置するコンテナ -->
<div class="main-container">

<!-- 左メニューエリア -->
<%@ include file="/side.jsp" %>

<!-- 右コンテンツエリア -->
<div class="content-container">
<h1>メニュー</h1>

    <div class="card-container">
<!-- 学生管理 -->
<div class="card card-red">
<a href="<%= request.getContextPath() %>/studentlist">学生管理</a>
</div>

        <!-- 成績管理 -->
<div class="card card-green">
<p>成績管理</p>
<!-- ↓ここの下の２つはまだ -->
<a href="<%= request.getContextPath() %>test/testregist">成績登録</a><br>
<a href="<c:url value='/main/TestListAction'/>">成績参照</a>
</div>

        <!-- 科目管理 -->
<div class="card card-purple">
    <a href="<%= request.getContextPath() %>/subjectlist">科目管理</a>
</div>
</div>
</div>

</div>


<%@ include file="/footer.jsp" %>