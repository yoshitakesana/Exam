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

<!-- 左側 -->
<div class="main-container">
  <div class="menu-wrapper">
    <%@ include file="side.jsp" %>
  </div>

<!-- 右側 -->
  <div class="content-container">
    <h2>成績管理</h2>
    
  </div>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>
