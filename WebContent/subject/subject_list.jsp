<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Subject" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>科目管理</title>
</head>
<body>

<jsp:include page="../header.jsp" />

<h1>科目管理</h1>

<c:if test="${empty list}">
    <p>現在、登録されている科目はありません。</p>
</c:if>

<c:if test="${not empty list}">
    <table border="1">
        <thead>
            <tr>
                <th>学校コード</th>
                <th>科目コード</th>
                <th>科目名</th>
                <th>操作</th> <!-- ★追加 -->
            </tr>
        </thead>
        <tbody>
            <c:forEach var="subject" items="${list}">
                <tr>
                    <td>${subject.schoolCd}</td>
                    <td>${subject.cd}</td>
                    <td>${subject.name}</td>
                    <td>
                        <!-- ★削除ボタンの追加 -->
                        <form action="${pageContext.request.contextPath}/SubjectDeleteAction" method="POST">

                            <input type="hidden" name="cd" value="${subject.cd}">
                            <input type="hidden" name="schoolCd" value="${subject.schoolCd}">
                            <input type="submit" value="削除">
                        </form>
                        <!-- ★変更ボタン -->
                        <form action="${pageContext.request.contextPath}/subject/subject_update.jsp" method="GET">
                            <input type="hidden" name="cd" value="${subject.cd}">
                            <input type="hidden" name="schoolCd" value="${subject.schoolCd}">
                            <input type="submit" value="変更">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<jsp:include page="../footer.jsp" />

</body>
</html>
