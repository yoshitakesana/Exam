<!-- 学生変更（STDM003）入力 -->
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../header.jsp" />

<h2>学生情報変更</h2>

	<label for="ent_year">入学年度</label><br>
	<input type="text" id="ent_year" name="ent_year" value="${ ent_year }" readonly>
	<br><br>

	<label for="no">学生番号</label><br>
	<input type="text" id="no" name="no" value="${ no }">
<form action="StudentUpdateAction" method="post">
</form>