package com.teachsync.controllers;

import com.teachsync.entities.Question;
import com.teachsync.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class TestController {

    private final QuestionRepository questionRepository;

    @Autowired
    public TestController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @PostMapping("/process-question")
    public String processQuestion(@RequestParam("numQuestions") int numQuestions,
                                  @RequestParam Map<String, String> requestParams) {
        for (int i = 1; i <= numQuestions; i++) {
            Question question = new Question();
            question.setQuestion(requestParams.get("question" + i));
            question.setAnswer1(requestParams.get("answer1_" + i));
            question.setAnswer2(requestParams.get("answer2_" + i));
            question.setAnswer3(requestParams.get("answer3_" + i));
            question.setAnswer4(requestParams.get("answer4_" + i));

            questionRepository.save(question);
        }

        // Redirect to a success page or do any other necessary actions

        return "redirect:/success";
    }
}
