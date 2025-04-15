<!-- 学生登録画面（STDM002) 入力 -->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List, java.util.Arrays" %>
<jsp:include page="../header.jsp" />

<h2>学生情報登録</h2>

<style>
    form {
        width: 100%; /* フォームの幅を設定 */
        margin: 0 auto; /* フォームを中央に配置 */
        padding: 20px; /* フォームの内側の余白を追加 */
    } select, input[type="text"] {
    	width: 100%;
    	padding:10px;
    	margin-bottom:10px;
    	box-sizing: border-box;
    } input[type="submit"] {
        width: auto; /* 自動幅に設定 */
        padding: 5px 10px; /* 小さくするためにパディングを調整 */
        margin-bottom: 10px;
        box-sizing: border-box;
        display: block; /* ブロック要素に変更 */
        margin-left: 0; /* 左寄せ */
    } .back_link{
    	display: block;
    	margin-top: 10;
    	text-align: left;
    }
</style>

<form action=" <!-- 完了画面に遷移する（完了画面を指定） --> " method="post" id="ent_year">
	<label>入学年度</label>
    <select name="ent_year">
        <option value="">--------</option>
        <c:forEach var="ent_year_item" items="${requestScope.ent_yearValues}">
            <option value="${ent_year_item}">${ent_year_item}</option>
        </c:forEach>
    </select>

    <label>学籍番号</label>
	<input type="text" name="no" value="${no}" maxlength="10" required placeholder="学籍番号を入力してください">

	<label>氏名</label>
	<input type="text" name="name" value="${name}" maxlength="30" required placeholder="氏名を入力してください">

	<label>クラス</label>
    <select name="class_num">
    	<c:forEach var="class_num_item" items="${requestScope.class_numValues }">
    		<option value="${class_num_item}">${class_num_item}</option>
    	</c:forEach>
    </select>

    <input type="submit" value="登録して終了">
    <a href="<!-- 学生管理一覧へ -->" class="back_link">戻る</a>
</form>

<jsp:include page="../footer.jsp" />
