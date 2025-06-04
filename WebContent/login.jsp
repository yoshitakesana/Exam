<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp" />
<%
    // セッションを破棄して新しく開始
    session.invalidate();
    session = request.getSession(true); // 新しいセッションを開始
%>

<style>
    .login-container {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        min-height: 80vh; /* ヘッダーやフッターを除いた高さ */
    }

    .login-form {
        width: 300px;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 8px;
        background-color: #f9f9f9;
        text-align: center;
    }

    .login-form label {
        display: block;
        margin-top: 10px;
        margin-bottom: 5px;
        text-align: left;
    }

    .login-form input[type="text"],
    .login-form input[type="password"] {
        width: 100%;
        padding: 5px;
        box-sizing: border-box;
    }

    .login-form input[type="submit"] {
        margin-top: 15px;
        width: 100%;
        padding: 8px;
        background-color: #ccc;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    .login-form input[type="submit"]:hover {
        background-color: #bbb;
    }

    .error-message {
        color: red;
        margin-bottom: 10px;
    }
</style>

<script>
	function togglePasswordVisibility() {
		var passwordField = document.getElementById("password");
		passwordField.type = (passwordField.type === "password") ? "text" : "password";
	}
</script>

<div class="login-container">
    <h2>ログイン</h2>

    <div class="login-form">
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
        <div class="error-message">
            ログインに失敗しました。IDまたはパスワードが正しくありません。
        </div>
        <%
            }
        %>

        <form method="post" action="<%= request.getContextPath() %>/LoginAction">
            <label for="id" class="id_label">ID</label>
            <input type="text" id="id" name="id" value="${ id }" maxlength="10" required style="ime-mode:disabled;">

            <label for="password" class="pass_label">パスワード</label>
            <input type="password" id="password" maxlength="30" name="password" required style="ime-mode:disabled;">

            <div style="text-align: left; margin-top: 5px;">
                <input type="checkbox" id="check_pass" onclick="togglePasswordVisibility()">
                <label for="check_pass">パスワードを表示</label>
            </div>

            <input type="submit" value="ログイン">
        </form>
    </div>
</div>

<jsp:include page="footer.jsp" />
