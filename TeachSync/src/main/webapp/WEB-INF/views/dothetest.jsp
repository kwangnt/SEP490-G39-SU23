<!DOCTYPE html>
<html>
<head>
    <title>Bài kiểm tra trắc nghiệm</title>
    <style>
        /* CSS cho giao diện */
        .question {
            margin-bottom: 20px;
        }
        .options {
            margin-top: 10px;
        }
        .option {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
<h1>Bài kiểm tra trắc nghiệm</h1>

<c:forEach items="${questions}" var="question">
    <div class="question">
        <h3>${question.questionText}</h3>
        <div class="options">
            <c:forEach items="${question.options}" var="option">
                <div class="option">
                    <input type="radio" name="${question.questionId}" value="${option.optionId}">
                    <label>${option.optionText}</label>
                </div>
            </c:forEach>
        </div>
    </div>
</c:forEach>

<button type="submit">Nộp bài</button>

<%-- Bạn cần thêm các thư viện JSTL và phần logic xử lý bài kiểm tra vào đây --%>

</body>
</html>
