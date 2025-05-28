<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/side.jsp" %>

<h1 style="margin-left: 220px;">成績登録</h1>

<div style="margin-left: 220px;"> <!-- ← ここで全体を右にずらす -->

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
    <select name="times">
        <option value="1" <c:if test="${param.times == '1'}">selected</c:if>>1</option>
        <option value="2" <c:if test="${param.times == '2'}">selected</c:if>>2</option>
    </select><br>

    <input type="submit" value="検索">
</form>

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
                        <input type="number" name="score" min="0" max="100">
                    </td>
                </tr>
            </c:forEach>
        </table>

        <input type="hidden" name="entYear" value="${param.entYear}">
        <input type="hidden" name="classNum" value="${param.classNum}">
        <input type="hidden" name="subjectCd" value="${param.subjectCd}">
        <input type="hidden" name="times" value="${param.times}">

        <input type="submit" value="登録">
    </form>
</c:if>

</div> <!-- ← ここでずらし終わり -->

<jsp:include page="../footer.jsp" />
