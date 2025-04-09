<!-- HTMLの型は完成しているけど、サーブレットに渡す情報の内容は適当に書いているだけです -->
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../header.jsp" />

<h2>科目情報変更</h2> <!-- ① 画面タイトル -->

<form action="UpdateSubject" method="post"> <!-- ⑥ 変更ボタンの遷移先 -->
    <!-- ② ラベル（固定） -->
    <label for="cd">科目コード：</label><br>
    <!-- ③ 科目コード（readonly） -->
    <input type="text" id="cd" name="cd"
           value="<%= request.getAttribute("cd") != null ? request.getAttribute("cd") : "" %>"
           readonly><br><br>

    <!-- ④ ラベル（固定） -->
    <label for="name">科目名：</label><br>
    <!-- ⑤ 科目名入力欄（最大20文字、必須） -->
    <input type="text" id="name" name="name" maxlength="20" required
           value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>"><br><br>

    <!-- ⑥ 変更ボタン -->
    <input type="submit" value="変更">
</form>

<!-- ⑦ 戻るリンク -->
<a href="subjectList.jsp">戻る</a>

<jsp:include page="../footer.jsp" />
