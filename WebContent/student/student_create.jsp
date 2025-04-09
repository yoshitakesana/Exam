<!-- 学生登録画面（STDM002) 入力 -->
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../header.jsp" />

<h2>学生情報登録</h2>
<label for="ent_year">入学年度</label>

<form id="ent_year"
action="<!-- データ送信先の名前（サーブレット名） -->"
method="post">
	<select name = "ent_year">
		<% List<String> ent_years = (List<String>) request.getAttribute("ent_years");
		if (ent_years != null) {
			for (String ent_year : ent_years) {
				out.println("<option value>");
			}
		}
		%>
	</select>
</form>

<jsp:include page="../footer.jsp" />
