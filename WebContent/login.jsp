<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp" />

<script>
	function togglePasswordVisibility() {
		var passwordField = document.getElementById("password");
		if (passwordField.type === "password") {
			passwordField.type = "text";
		} else {
			passwordField.type = "password";
		}
	}
</script>


rrn
<h2>ログイン</h2>

<%
    // エラーメッセージがセットされている場合だけ表示
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
<ul>
    <li><p>ログインに失敗しました。IDまたはパスワードが正しくありません。</p></li>
</ul>
<%
    }
%>


<form method="post" action="<%= request.getContextPath() %>/LoginExcecute">
	<label for="id" class="id_label">ID</label>
	<input type="text" id="id" name="id" value="${ id }" maxlength="10" required style="ime-mode:disabled;">
	<br><br>

	<label for="password" class="pass_label">パスワード</label>
	<input type="password" id="password" maxlength="30" name="password" required style="ime-mode:disabled;">
	<br><br>

	<input type="checkbox" id="check_pass" onclick="togglePasswordVisibility()">
	<label for="check_pass">パスワードを表示</label>
	<br><br>

	<input type="submit" value="ログイン">

</form>

<jsp:include page="footer.jsp" />
