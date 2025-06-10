<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Subject" %>
<%@ include file="/header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

<!-- 左メニューエリア -->
<%@ include file="/side.jsp" %>

<!-- 右コンテンツエリア -->
<div class="content-container">

    <title>科目管理</title>

    <!-- タイトル -->
    <h1 class="section-title">科目管理</h1>

    <!-- 科目新規登録リンク（右寄せ） -->
    <div style="text-align: right; margin-bottom: 20px;">
        <a href="${pageContext.request.contextPath}/SubjectCreateAction"
           style="color: #0000EE; text-decoration: underline;">
            新規登録
        </a>
    </div>

    <!-- 科目一覧表示 -->
    <c:if test="${empty list}">
        <p>現在、登録されている科目はありません。</p>
    </c:if>

    <c:if test="${not empty list}">
        <table class="subject-table">
            <thead>
                <tr>
                    <th>科目コード</th>
                    <th>科目名</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="subject" items="${list}">
                    <tr>
                        <td>${subject.cd}</td>
                        <td>${subject.name}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/SubjectUpdateAction?cd=${subject.cd}&schoolCd=${subject.schoolCd}">変更</a>
                            　
                            <form action="${pageContext.request.contextPath}/SubjectDeleteAction" method="post" style="display:inline;">
    <input type="hidden" name="cd" value="${subject.cd}">
    <input type="hidden" name="schoolCd" value="${subject.schoolCd}">
    <input type="submit" value="削除" onclick="return confirm('本当に削除しますか？');" style="background-color:#dc3545; color:white; border:none; padding:4px 10px; border-radius:3px; cursor:pointer;">
</form>

                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>

<jsp:include page="../footer.jsp" />
