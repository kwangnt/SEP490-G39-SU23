<!DOCTYPE html>
<html>
<head>
    <title>Tạo bài test</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: #f4f4f4;
        }

        .container {
            max-width: 500px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        select, input[type="number"] {
            margin-bottom: 10px;
            width: 100%;
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        .question-container {
            margin-bottom: 20px;
        }

        .question-container label {
            margin-bottom: 5px;
        }

        .question-container input {
            margin-bottom: 10px;
            width: 100%;
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        #submit-btn {
            display: block;
            margin: 20px auto;
            padding: 10px 20px;
            font-size: 16px;
            font-weight: bold;
            border-radius: 5px;
            border: none;
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }

        #submit-btn:hover {
            background-color: #45a049;
        }
    </style>
    <script>
        function createFields() {
            var questionType = document.getElementById('questionType').value;
            var numQuestions = document.getElementById('numQuestions').value;
            var container = document.getElementById('questionContainer');
            container.innerHTML = '';

            for (var i = 1; i <= numQuestions; i++) {
                var questionDiv = document.createElement('div');
                questionDiv.className = 'question-container';

                var questionLabel = document.createElement('label');
                questionLabel.textContent = 'Câu hỏi ' + i + ': ';
                var questionInput = document.createElement('input');
                questionInput.type = 'text';
                questionInput.name = 'question' + i;

                questionDiv.appendChild(questionLabel);
                questionDiv.appendChild(questionInput);

                if (questionType === 'multiple-choice') {
                    for (var j = 1; j <= 4; j++) {
                        var answerLabel = document.createElement('label');
                        answerLabel.textContent = 'Đáp án ' + j + ': ';
                        var answerInput = document.createElement('input');
                        answerInput.type = 'text';
                        answerInput.name = 'answer' + i + '_' + j;

                        questionDiv.appendChild(answerLabel);
                        questionDiv.appendChild(answerInput);
                    }
                }

                container.appendChild(questionDiv);
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h1>Tạo bài test</h1>

    <form id="testForm">
        <label>Loại bài test:</label>
        <select id="questionType" name="questionType">
            <option value="multiple-choice">Trắc nghiệm</option>
            <option value="essay">Tự luận</option>
        </select>

        <label>Số lượng câu hỏi:</label>
        <input type="number" id="numQuestions" name="numQuestions" min="1" max="10">

        <button type="button" onclick="createFields()">Tạo trường câu hỏi</button>

        <div id="questionContainer"></div>

        <button type="submit" id="submit-btn">Submit</button>
    </form>
</div>
</body>
</html>
