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

<form action="<%= request.getContextPath() %>/StudentCreateExecuteAction" method="post">



    <label for="no">学生番号:</label>
    <input type="text" name="no" id="no" placeholder="学籍番号を入力してください" required><br>


<label for="name">学生名:</label>
    <input type="text" name="name" id="name"placeholder="名前を入力してください" required><br>

    <label for="entYear">入学年度:</label>
    <select name="entYear" id="entYear">
        <c:forEach var="year" items="${yearList}">
            <option value="${year}">${year}</option>
        </c:forEach>
    </select><br>

    <label for="classNum">クラス番号:</label>
    <input type="text" name="classNum" id="classNum" required placeholder="クラス番号を入力してください"><br>

    <button type="submit">登録</button>
</form>

<jsp:include page="../footer.jsp" />
