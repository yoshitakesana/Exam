<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>学生管理システム</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>

<jsp:include page="header.jsp" />

<div class="main-container">
  <div class="menu-wrapper">
    <%@ include file="side.jsp" %>
  </div>

  <div class="content-container">
    <h2>メニュー</h2>
    <a href="#">学生管理</a>
    <div>成績管理</div>
    <a href="#">成績登録</a>
    <a href="#">成績参照</a><br>
    <a href="#">科目管理</a>
  </div>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>
