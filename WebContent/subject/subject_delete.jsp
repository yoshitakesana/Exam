
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../header.jsp" />

<h2>科目情報削除</h2>
<!-- ↓ここは本当はサーブレットから削除したい科目を持ってくる -->
<label>〇〇〇を削除してもよろしいですか</label>
<!-- ↓このボタンも適当に設置しただけ -->
<input type="submit" name="action" value="削除">
<p><a href="subject_list.jsp">科目一覧</a></p>

<jsp:include page="../footer.jsp" />

