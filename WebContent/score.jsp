<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <label for="ENT_YEAR">入学年度</label>
    <label for="CLASS_NUM">クラス</label>
    <label for="SUBJECT_CD">科目</label>
    <label for="NO">回数</label><br>
	<c:forEach var="student" items="${students}">
	<tr>
	<td>${student.entYear}</td>
	<td>${student.classNum}</td>
	<td>${student.isAttend ? '出席' : '欠席'}</td>
	<td>${student.schoolCd}</td>
	</tr>
	</c:forEach>
    <button type="submit">検索</button>
  </div>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>
