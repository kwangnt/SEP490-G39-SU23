<%--
  Created by IntelliJ IDEA.
  User: Tha
  Date: 6/13/2023
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div class="container">
    <h2>Chỉnh sửa bài báo</h2>
    <form action="submitcreatenews" method="post">
        <input type="hidden" id="idNews" name="idNews">
        <div class="form-group">
            <label for="title">Tiêu đề:</label>
            <input type="text" id="title" name="title" required>
        </div>

        <div class="form-group">
            <label for="description">Tóm tắt:</label>
            <textarea id="description" name="description" required></textarea>
        </div>

        <div class="form-group">
            <label for="content">Nội dung:</label>
            <textarea id="content" name="content" required></textarea>
        </div>

        <button type="submit">Lưu</button>
    </form>
</div>

<%@ include file="/WEB-INF/fragments/footer.jspf" %>

</body>
</html>
