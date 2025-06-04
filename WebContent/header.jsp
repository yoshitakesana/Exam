<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8" />
  <title>得点管理システム</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
</head>
<body>

<header>
  <div class="titlehaikei flex-between-center">
    <h1 style="margin: 0;">得点管理システム</h1>

    <div style="font-size: 0.9em;">
      <%
      bean.Teacher teacher = (bean.Teacher) session.getAttribute("teacher");
      if (teacher != null) {
      %>
        <span><%= teacher.getName() %>様 <a href="<%= request.getContextPath() %>/LogoutAction">ログアウト</a></span>
      <%
      }
      %>
    </div>
  </div>
</header>

<!-- 他のコンテンツ -->

</body>
</html>
