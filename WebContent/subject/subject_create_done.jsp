<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../header.jsp" />

<h2>科目情報登録</h2>
<label>登録完了しました</label>
<!-- 科目登録画面に戻るリンク -->
<a href="../SubjectCreateAction">戻る</a>
<!--科目一覧画面のリンク -->

<a href="<%= request.getContextPath() %>/subjectlist">科目一覧</a>


<jsp:include page="../footer.jsp" />
