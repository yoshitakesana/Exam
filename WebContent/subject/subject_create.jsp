<!-- html部分は完成しているけど、中身（javaに送る情報）は適当に書いてるだけです -->
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../header.jsp" />

<h2>科目情報登録</h2> <!-- ① 見出し（h2） -->

<!-- ②〜⑤ 入力フォーム -->
<form action="〇〇java" method="post">
    <!-- ② ラベル -->
    <label for="cd">科目コード：</label>
    <!-- ③ テキストボックス -->
    <input type="text" name="cd" id="cd"
           value="<%= request.getAttribute("cd") != null ? request.getAttribute("cd") : "" %>"><br><br>

    <!-- ④ ラベル -->
    <label for="name">科目名：</label>
    <!-- ⑤ テキストボックス -->
    <input type="text" name="name" id="name"
           value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>"><br><br>

    <!-- ⑥ 登録ボタン -->
    <input type="submit" value="登録"><br><br>
</form>

<!-- ⑦ 戻るリンク -->
<a href="menu.jsp">戻る</a> <!-- 必要に応じて戻り先を変更してください -->

<jsp:include page="../footer.jsp" />
