<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>学生管理システム</title>
  <link rel="stylesheet" href="style.css">
  <style>
        body {
            font-family: sans-serif;
        }

        .container {
            padding: 20px;
        }

        h2 {
            margin-bottom: 15px;
        }

        .search-area {
            display: flex;
            gap: 40px;
            align-items: flex-end;
            background-color: #f8f9fa;
            padding: 20px;
            border-radius: 8px;
            flex-wrap: wrap;
        }

        .form-group {
            display: flex;
            flex-direction: column;
        }

        .form-group label {
            font-size: 14px;
            margin-bottom: 5px;
        }

        select {
            padding: 5px;
            width: 150px;
        }

        .form-group.button {
            margin-top: 23px;
        }

        .form-group.button button {
            padding: 8px 16px;
            background-color: #6c757d;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .form-group.button button:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>

<jsp:include page="../header.jsp" />

<!-- 左側 -->
<div class="main-container">
  <div class="menu-wrapper">
    <%@ include file="../side.jsp" %>
  </div>

<!-- 右側 -->

    <div class="container">
    <!-- タイトル -->
    <h2>成績参照</h2>


    <!-- ラベル＋セレクトをセットで並べる -->
    <div class="search-area">
    <p>科目情報</p>
        <!-- 入学年度 -->
        <div class="form-group">
            <label for="f1">入学年度</label>
            <select name="f1" id="f1">
                <option value="">--------</option>
                <option value="2023">2023年</option>
                <option value="2024">2024年</option>
                <option value="2025">2025年</option>
            </select>
        </div>

        <!-- クラス -->
        <div class="form-group">
            <label for="f2">クラス</label>
            <select name="f2" id="f2">
                <option value="">--------</option>
                <option value="A">A組</option>
                <option value="B">B組</option>
                <option value="C">C組</option>
            </select>
        </div>

        <!-- 科目 -->
        <div class="form-group">
            <label for="f3">科目</label>
            <select name="f3" id="f3">
                <option value="">--------</option>
                <option value="math">数学</option>
                <option value="japanese">国語</option>
                <option value="science">理科</option>
            </select>
        </div>


        <!-- 検索ボタン -->
        <div class="form-group button">
            <button type="submit">検索</button>
        </div>

		<div style="flex-basis: 100%; height: 30px;"></div>

        <p>学生情報</p>
        <!-- 学生番号 -->
        <div class="form-group">
            <label for="f4">学生番号</label>
            <input type="text" name="no"></input>
        </div>


        <!-- 検索ボタン -->
        <div class="form-group button">
            <button type="submit">検索</button>
        </div>
    </div>
</div>

</div>
<p>科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</p>

<jsp:include page="../footer.jsp" />

</body>
</html>


