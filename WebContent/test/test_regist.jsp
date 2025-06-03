<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/side.jsp" %>

<!-- 省略：共通インクルードやスタイル -->

<h1 style="margin-left: 220px;">成績登録</h1>

<div style="margin-left: 220px;">

<%
    int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    pageContext.setAttribute("currentYear", currentYear);
%>

<form action="${pageContext.request.contextPath}/testregist" method="get">
    入学年度：
    <select name="entYear">
        <c:forEach var="year" begin="${currentYear - 10}" end="${currentYear + 10}">
            <option value="${year}" <c:if test="${param.entYear == (year + '')}">selected</c:if>>${year}</option>
        </c:forEach>
    </select><br>

    クラス：
    <select name="classNum">
        <c:forEach var="cls" items="${classList}">
            <option value="${cls.class_num}" <c:if test="${param.classNum == cls.class_num}">selected</c:if>>
                ${cls.class_num}
            </option>
        </c:forEach>
    </select><br>

    科目：
    <select name="subjectCd">
        <c:forEach var="subj" items="${subjectList}">
            <option value="${subj.cd}" <c:if test="${param.subjectCd == subj.cd}">selected</c:if>>
                ${subj.name}
            </option>
        </c:forEach>
    </select><br>

    回数：
    <select name="no">
        <option value="1" <c:if test="${param.no == '1'}">selected</c:if>>1</option>
        <option value="2" <c:if test="${param.no == '2'}">selected</c:if>>2</option>
    </select><br>

    <input type="submit" value="検索">
</form>

<!-- ここから追加部分 -->
<c:if test="${not empty param.subjectCd && not empty param.no}">
    <p style="margin-left: 220px; font-weight: bold; margin-top: 20px;">
        科目：
        <c:forEach var="subj" items="${subjectList}">
            <c:if test="${subj.cd == param.subjectCd}">
                ${subj.name}
            </c:if>
        </c:forEach>
        （${param.no}回）
    </p>
</c:if>
<!-- 追加部分ここまで -->

<c:if test="${not empty list}">
    <form action="${pageContext.request.contextPath}/testregistexecute" method="post">
        <table border="1">
            <tr>
                <th>学生番号</th><th>氏名</th><th>点数</th>
            </tr>
            <c:forEach var="stu" items="${list}">
                <tr>
                    <td>${stu.no}</td>
                    <td>${stu.name}</td>
                    <td>
                        <input type="hidden" name="studentNo" value="${stu.no}">
                        <input type="number" name="point" min="0" max="100">
                    </td>
                </tr>
            </c:forEach>
        </table>

        <input type="hidden" name="entYear" value="${param.entYear}">
        <input type="hidden" name="classNum" value="${param.classNum}">
        <input type="hidden" name="subjectCd" value="${param.subjectCd}">
        <input type="hidden" name="no" value="${param.no}">
        <input type="hidden" name="schoolCd" value="${sessionScope.user.school.cd}">

        <input type="submit" value="登録">
    </form>
</c:if>

</div>

<jsp:include page="../footer.jsp" />
