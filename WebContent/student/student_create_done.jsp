<!-- 学生登録完了（STDM003）確認 -->
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../header.jsp" />

<h2>学生情報登録</h2>
<p>登録が完了しました</p>

<a href="/StudentCreateAction">戻る</a>
<a href="<%= request.getContextPath() %>/studentlist">学生一覧</a>

<jsp:include page="../footer.jsp" />




<!-- [未記述] 各遷移リンク -->