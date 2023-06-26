<%--
  Created by IntelliJ IDEA.
  User: Tha
  Date: 6/26/2023
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Edit Test</title>

    <link rel="stylesheet" href="../../resources/css/bootstrap-5.3.0/bootstrap.css">

    <link rel="stylesheet" href="../../resources/css/teachsync_style.css">

    <script src="../../resources/js/jquery/jquery-3.6.3.js"></script>
    <script src="../../resources/js/bootstrap-5.3.0/bootstrap.js"></script>

    <script src="../../resources/js/common.js"></script>
    <style>
        /* Áp dụng CSS để tùy chỉnh giao diện form */
        .container {
            width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            border-radius: 3px;
            border: 1px solid #ccc;
        }

        textarea {
            height: 150px;
        }

        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<h1>Sửa bài test</h1>

<form action="process-question" method="post">
    <label for="question-type">Môn học:</label>
    <select name="courseName">
        <c:forEach var="item" items="${lstCourse}">
            <option value="${item.id} ${item.id == test.courseId ? 'selected' : ''}">${item.courseName}</option>
        </c:forEach>
    </select>
    <label for="question-type">Loại kiểm tra:</label>
    <select name="testType">
        <option value="15min"  ${test.testName == '15min' ? 'selected' : ''}>15 phút</option>
        <option value="midterm" ${test.testName == 'midterm' ? 'selected' : ''}>Giữa kỳ</option>
        <option value="final" ${test.testName == 'final' ? 'selected' : ''}>Cuối kỳ</option>
    </select>
    <label for="num-questions">Thời gian:</label>
    <input type="number" id="timeLimit" name="timeLimit" min="1" value="${test.timeLimit}" required>
    <label for="question-type">Loại câu hỏi:</label>
    <select id="question-type" name="questionType">
        <option value="essay" ${test.testType == 'essay' ? 'selected' : ''}>Tự luận</option>
        <option value="multipleChoice" ${test.testType == 'multipleChoice' ? 'selected' : ''}>Trắc nghiệm</option>
    </select>

    <label for="num-questions">Số lượng câu hỏi:</label>
    <input type="number" id="num-questions" name="numQuestions" min="1" value="${test.numQuestion}" required>
</form>
</body>
</html>
