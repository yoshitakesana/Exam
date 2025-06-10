<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../header.jsp" />
<jsp:include page="/side.jsp" />
<div class="content-container">
<h2 style="background-color: #e1e1e1; padding: 10px 15px; border-radius: 4px;">
  科目情報変更
</h2>


<form action="<%= request.getContextPath() %>/SubjectUpdateExecuteAction" method="post">
    <label for="cd">科目コード：</label><br>
    <!-- ✅ 修正ポイント: request.getAttribute("cd") で取得 -->
    <input type="text" id="cd" name="cd"
           value="${cd}" readonly><br><br>

    <label for="name">科目名：</label><br>
    <input type="text" id="name" name="name" maxlength="20" required
           value="${name}"><br><br>

    <input type="submit" value="変更"
       style="background-color: #007bff; color: white; border: none; padding: 8px 16px; border-radius: 4px; cursor: pointer;">

</form>

<a href="${pageContext.request.contextPath}/subjectlist">戻る</a>

</div>
<jsp:include page="../footer.jsp" />
