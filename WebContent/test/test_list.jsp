<!-- 成績参照検索 GRMR001 -->
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

<!-- 左メニューエリア -->
<%@ include file="/side.jsp" %>

<h2>成績管理</h2>

<form action="＊＊＊＊" method="post">
	<div>
		<label for="f1">入学年度</label>
		<select name="f1" id="f1">
			<option value=""> -------- </option>
			<c:forEach var="year" items="${ yearList }">
				<option value="${ year }">${ year }</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<label for="f2">クラス</label>
		<select name="f2" id="f2">
			<!-- クラスの表示 -->
		</select>
	</div>
	<div>
		<label for="f3">科目</label>
		<select name="f3" id="f3">
			<!-- 科目の表示 -->
		</select>
	</div>
	<div>
		<label for="f4">回数</label>
		<select name="f4" id="f4">
			<!-- 回数の表示 -->
		</select>
	</div>
	<div>
		<button type="submit">検索</button>
	</div>
</form>


<jsp:include page="../footer.jsp" />