<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Student" %>
<%@ page import="dao.StudentDAO" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>生徒情報検索</title>
</head>
<body>
    <h1>生徒情報検索</h1>

    <!-- 絞り込み条件入力フォーム -->
    <form action="studentlist" method="get">
        <label for="entYear">入学年度：</label>
        <input type="number" name="entYear" id="entYear"><br>

        <label for="classNum">クラス番号：</label>
        <input type="text" name="classNum" id="classNum"><br>

        <label for="isAttend">在学中：</label>
        <input type="checkbox" name="isAttend" value="true"> 在学中<br>

        <input type="submit" value="検索">
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
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${list}">
                    <tr>
                        <td>${student.no}</td>
                        <td>${student.name}</td>
                        <td>${student.entYear}</td>
                        <td>${student.classNum}</td>
                        <td>${student.isAttend ? '在学中' : '卒業'}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty list}">
        <p>検索結果がありません。</p>
    </c:if>
</body>
</html>
