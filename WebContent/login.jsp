
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp" />


<h2>ログインページ</h2>
<form method="post" action="login">
    ユーザー名：<input type="text" name="username"><br>
    パスワード：<input type="password" name="password"><br>
    <input type="submit" value="ログイン">
</form>

<jsp:include page="footer.jsp" />
