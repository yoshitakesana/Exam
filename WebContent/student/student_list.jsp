<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Student" %>
<%@ page import="dao.StudentDao" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/header.jsp" %>


<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

<!-- 左メニューエリア -->
<%@ include file="/side.jsp" %>

<!-- 右コンテンツエリア -->
<div class="content-container">

   <h1 class="section-title">学生管理</h1>


<!-- 新規登録リンク（右寄せ） -->
<p style="margin-bottom: 1em; text-align: right;">
    <a href="${pageContext.request.contextPath}/StudentCreateAction" class="link-button">新規登録</a>
</p>



    <!-- 絞り込み条件入力フォーム -->
    <form action="${pageContext.request.contextPath}/studentlist" method="get" class="filter-form">
        <label for="entYear">入学年度：</label>
        <input type="number" name="entYear" id="entYear" value="${param.entYear}">

        <label for="classNum">クラス：</label>
        <input type="text" name="classNum" id="classNum" value="${param.classNum}">

        <label for="isAttend">在学中：</label>
        <input type="checkbox" name="isAttend" value="true" <c:if test="${param.isAttend == 'true'}">checked</c:if> >

        <input type="submit" value="絞り込み">
    </form>

    <h2>検索結果</h2>

    <c:if test="${not empty list}">
        <table border="1">
            <thead>
                <tr>
                    <th>学籍番号</th>
                    <th>名前</th>
                    <th>入学年度</th>
                    <th>クラス番号</th>
                    <th>在学中</th>
                    <th>操作</th> <!-- ★ 変更操作 -->
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${list}">
                    <tr>
                        <td>${student.no}</td>
                        <td>${student.name}</td>
                        <td>${student.entYear}</td>
                        <td>${student.classNum}</td>
                        <td><c:out value="${student.isAttend ? '在学中' : '卒業'}"/></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/StudentUpdateAction" method="get">
                                <input type="hidden" name="studentNo" value="${student.no}">
                                <input type="hidden" name="schoolCd" value="${student.schoolCd}">
                                <input type="submit" value="変更">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

</div>

<%@ include file="/footer.jsp" %>
