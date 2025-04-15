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
        padding: 10px;
        margin-bottom: 10px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        width: auto; /* 自動幅に設定 */
        padding: 5px 10px; /* 小さくするためにパディングを調整 */
        margin-bottom: 10px;
        box-sizing: border-box;
        display: block; /* ブロック要素に変更 */
        margin-left: 0; /* 左寄せ */
    }
    .back-link {
        display: block; /* ブロック要素に変更 */
        margin-top: 10px; /* 上部の余白を追加 */
        text-align: left; /* 左寄せ */
    }
    .error {
        color: red; /* エラーメッセージの色を赤に設定 */
        margin-bottom: 10px; /* 下部の余白を追加 */
    }
</style>

<script>
    function validateForm() {
        var entYear = document.forms["ent_year"]["ent_year"].value;
        var studentNo = document.forms["ent_year"]["no"].value;
        var errorMessageYear = document.getElementById("error-message-year");
        var errorMessageNo = document.getElementById("error-message-no");

        // エラーメッセージを初期化
        errorMessageYear.textContent = "";
        errorMessageNo.textContent = "";

        var isValid = true;

        if (entYear == "") {
            errorMessageYear.textContent = "入学年度を選択してください";
            isValid = false;
        }

        if (studentNo == "") {
            errorMessageNo.textContent = "学生番号を入力してください";
            isValid = false;
        }

        // 学生番号の重複チェック（サーバー側で行う必要があります）
        var isDuplicate = false; // ここでサーバー側の重複チェック結果を取得する
        if (isDuplicate) {
            errorMessageNo.textContent = "学生番号が重複しています";
            isValid = false;
        }

        return isValid;
    }
</script>

<form action="complete.jsp" method="post" id="ent_year" onsubmit="return validateForm()">
    <label>入学年度</label>
    <select name="ent_year">
        <option value="">--------</option>
        <c:forEach var="ent_year_item" items="${requestScope.ent_yearValues}">
            <option value="${ent_year_item}">${ent_year_item}</option>
        </c:forEach>
    </select>
    <div id="error-message-year" class="error"></div> <!-- 入学年度のエラーメッセージ -->

    <label>学籍番号</label>
    <input type="text" name="no" value="${no}" maxlength="10" required placeholder="学籍番号を入力してください">
    <div id="error-message-no" class="error"></div> <!-- 学籍番号のエラーメッセージ -->

    <label>氏名</label>
    <input type="text" name="name" value="${name}" maxlength="30" required placeholder="氏名を入力してください">

    <label>クラス</label>
    <select name="class_num">
        <c:forEach var="class_num_item" items="${requestScope.class_numValues}">
            <option value="${class_num_item}">${class_num_item}</option>
        </c:forEach>
    </select>

    <input type="submit" value="登録して終了">
    <a href="home.jsp" class="back-link">戻る</a>
</form>

<jsp:include page="../footer.jsp" />
