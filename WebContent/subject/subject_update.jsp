<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../header.jsp" />

<h2>科目情報変更</h2>

<form action="<%= request.getContextPath() %>/SubjectUpdateExecuteAction" method="post">
    <label for="cd">科目コード：</label><br>
    <!-- ✅ 修正ポイント: request.getAttribute("cd") で取得 -->
    <input type="text" id="cd" name="cd"
           value="${cd}" readonly><br><br>

    <label for="name">科目名：</label><br>
    <input type="text" id="name" name="name" maxlength="20" required
           value="${name}"><br><br>

    <input type="submit" value="変更">
</form>

<a href="subjectList.jsp">戻る</a>

<jsp:include page="../footer.jsp" />
