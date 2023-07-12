<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bài kiểm tra trắc nghiệm</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="../../resources/css/bootstrap-5.3.0/bootstrap.css">

    <link rel="stylesheet" href="../../resources/css/teachsync_style.css">

    <script src="../../resources/js/jquery/jquery-3.6.3.js"></script>
    <script src="../../resources/js/bootstrap-5.3.0/bootstrap.bundle.js"></script>

    <script src="../../resources/js/common.js"></script>
    <style>
        .question {
            margin-bottom: 20px;
        }

        .question h3 {
            font-weight: bold;
            margin-bottom: 10px;
        }

        .question label {
            display: block;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
<h1>Bài kiểm tra trắc nghiệm</h1>

<form action="your-submit-action" method="post">
    <input type="hidden" name="idTest" value="idTest" >
    <c:forEach var="entry" items="${hmQA}">
        <div class="question">
            <h3>${entry.key.questionDesc}</h3>
            <c:forEach var="answer" items="${entry.value}">
                <label>
                    <input type="radio" name="${entry.key.id}" value="${answer.id}">
                        ${answer.answerDesc}
                </label>
            </c:forEach>
        </div>
    </c:forEach>

    <input type="submit" value="Nộp bài">
</form>

<%-- Bạn cần thêm các thư viện JSTL và phần logic xử lý bài kiểm tra vào đây --%>

</body>
</html>
