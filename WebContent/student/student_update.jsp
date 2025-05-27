<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="../header.jsp" />

<h2>学生情報変更</h2>

<form action="${pageContext.request.contextPath}/StudentUpdateExecuteAction" method="post">

    <!-- 表示だけする（送信にはhiddenを使う） -->
    <label>入学年度</label><br>
    <span>${student.entYear}</span><br>
    <input type="hidden" name="entYear" value="${student.entYear}">
    <br><br>

    <label>学生番号</label><br>
    <span>${student.no}</span><br>
    <input type="hidden" name="no" value="${student.no}">
    <br><br>

    <!-- 変更可能な項目 -->
    <label for="name">氏名</label><br>
    <input type="text" id="name" name="name" value="${student.name}" maxlength="30" required>
    <br><br>

    <label for="class_num">クラス</label><br>
    <!-- ここをselectからinputテキストに変更 -->
    <input type="text" id="class_num" name="classNum" value="${student.classNum}" maxlength="10" required>
    <br><br>

    <label for="is_attend">在学中</label><br>
    <input type="checkbox" id="is_attend" name="isAttend" value="true" ${student.attend ? "checked" : ""}>
    <br><br>

    <input type="submit" value="変更">
</form>

<a href="${pageContext.request.contextPath}/StudentListAction">戻る</a>
