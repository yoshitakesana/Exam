<!-- GRMR002 科目別成績一覧 -->
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

<!-- 左メニューエリア -->
<%@ include file="/side.jsp" %>

<h1>成績登録</h1>

<form action="${pageContext.request.contextPath}/TestRegistAction" method="get">
    入学年度：
<select name="entYear">
<c:forEach var="year" begin="${currentYear - 10}" end="${currentYear + 10}">
<option value="${year}">${year}</option>
</c:forEach>
</select><br>

    クラス：
<input type="text" name="classNum"><br>

    科目：
<select name="subjectCd">
<c:forEach var="subject" items="${subjectList}">
<option value="${subject.cd}">${subject.name}</option>
</c:forEach>
</select><br>

    回数：
<input type="number" name="times" min="1"><br>

    <input type="submit" value="検索">
</form>


<jsp:include page="../footer.jsp" />