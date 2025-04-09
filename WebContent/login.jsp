<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp" />

<h2>ログインページ</h2>

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

<form method="post" action="login">
    ID：<input type="text" name="userId"><br>
    パスワード：<input type="password" name="password"><br>
    <input type="submit" value="ログイン">
</form>

<jsp:include page="footer.jsp" />
