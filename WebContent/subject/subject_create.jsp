<!-- html部分は完成しているけど、中身（javaに送る情報）は適当に書いてるだけです -->
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../header.jsp" />
<%@ include file="/side.jsp" %>

<div class="content-container">
<h2 style="background-color: #e1e1e1; padding: 10px 15px; border-radius: 4px;">
  科目情報登録
</h2>


<!-- ②〜⑤ 入力フォーム -->
<form action="<%= request.getContextPath() %>/SubjectCreateExecuteAction" method="post">


    <!-- ② ラベル -->
    <label for="cd">科目コード：</label>
    <!-- ③ テキストボックス -->
    <input type="text" name="cd" id="cd"
       placeholder="科目を入力してください"
       value="<%= request.getAttribute("cd") != null ? request.getAttribute("cd") : "" %>"><br><br>

    <!-- ④ ラベル -->
    <label for="name">科目名：</label>
    <!-- ⑤ テキストボックス -->
    <input type="text" name="name" id="name"
           placeholder="科目名を入力してください"
           value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>"><br><br>

    <!-- ⑥ 登録ボタン -->
<input type="submit" value="登録"
       style="background-color: #007bff; color: white; border: none; padding: 8px 16px; border-radius: 4px; cursor: pointer;">

</form>

<!-- ⑦ 戻るリンク -->
<a href="menu.jsp">戻る</a> <!-- 必要に応じて戻り先を変更してください -->

</div>
<jsp:include page="../footer.jsp" />
