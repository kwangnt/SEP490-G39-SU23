<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang tạo câu hỏi</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        form {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="number"],
        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 14px;
            margin-bottom: 10px;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Tạo câu hỏi</h1>
<form action="process-question" method="post">
    <label for="numQuestions">Số lượng câu hỏi:</label>
    <input type="number" id="numQuestions" name="numQuestions" min="1" required>
    <br><br>
    <div id="questions-container"></div>
    <button type="button" onclick="generateQuestions()">Tạo câu hỏi</button>
    <br>
    <input type="submit" value="Hoàn thành">
</form>

<script>
    function generateQuestions() {
        const numQuestionsInput = document.getElementById('numQuestions');
        const numQuestions = parseInt(numQuestionsInput.value);

        if (numQuestions <= 0) {
            alert('Số lượng câu hỏi phải lớn hơn 0.');
            return;
        }

        const questionsContainer = document.getElementById('questions-container');
        questionsContainer.innerHTML = '';

        for (let i = 1; i <= numQuestions; i++) {
            const questionDiv = document.createElement('div');
            questionDiv.className = 'question';

            const questionContentLabel = document.createElement('label');
            questionContentLabel.htmlFor = 'question' + i;
            questionContentLabel.className = 'question-content';
            questionContentLabel.appendChild(document.createTextNode('Câu hỏi ' + i + ':'));
            questionDiv.appendChild(questionContentLabel);

            const questionInput = document.createElement('input');
            questionInput.type = 'text';
            questionInput.id = 'question' + i;
            questionInput.name = 'question' + i;
            questionInput.required = true;
            questionDiv.appendChild(questionInput);
            questionDiv.appendChild(document.createElement('br'));

            for (let j = 1; j <= 4; j++) {
                const answerLabel = document.createElement('label');
                answerLabel.htmlFor = 'answer' + j + '_' + i;
                answerLabel.className = 'answer';
                answerLabel.appendChild(document.createTextNode('Câu trả lời ' + j + ':'));
                questionDiv.appendChild(answerLabel);

                const answerInput = document.createElement('input');
                answerInput.type = 'text';
                answerInput.id = 'answer' + j + '_' + i;
                answerInput.name = 'answer' + j + '_' + i;
                answerInput.required = true;
                questionDiv.appendChild(answerInput);
                questionDiv.appendChild(document.createElement('br'));
            }

            questionsContainer.appendChild(questionDiv);
        }
    }
</script>
</body>
</html>