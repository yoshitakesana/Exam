<!-- 学生変更（STDM003）入力 -->
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../header.jsp" />

<h2>学生情報変更</h2>

<form action="StudentUpdateAction" method="post">
	<label for="ent_year">入学年度</label><br>
	<input type="text" id="ent_year" name="ent_year" value="${ ent_year }" readonly>
	<br><br>

	<label for="no">学生番号</label><br>
	<input type="text" id="no" name="no" value="${ no }" readonly>
	<br><br>


	<label for="name">氏名</label><br>
	<input type="text" id="name" name="name" value="${ name }" maxlength="30" required>
	<br><br>

	<label for="class_num">クラス</label><br>
	<select id="class_num" name="class_num">
		<!-- クラス番号テーブルからクラス番号を動的に取得して表示 -->
	</select>
	<br><br>

	<label for="is_attend">在学中</label><br>
	<input type="checkbox" id="is_attend" name="is_attend">
	<br><br>

	<input type="submit" value="変更">
</form>

<a href="studentList.jsp">戻る</a>