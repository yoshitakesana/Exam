<!-- HTMLの型は完成しているけど、サーブレットに渡す情報の内容は適当に書いているだけです -->
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../header.jsp" />

<h2>科目情報変更</h2> <!-- ① 画面タイトル -->

<form action="<%= request.getContextPath() %>/SubjectUpdateExecuteAction" method="post">
    <label for="cd">科目コード：</label><br>
    <input type="text" id="cd" name="cd"
           value="<%= request.getAttribute("cd") != null ? request.getAttribute("cd") : "" %>"
           readonly><br><br>

    <label for="name">科目名：</label><br>
    <input type="text" id="name" name="name" maxlength="20" required
           value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>"><br><br>

    <input type="submit" value="変更">
</form>


<!-- ⑦ 戻るリンク -->
<a href="subjectList.jsp">戻る</a>

<jsp:include page="../footer.jsp" />
