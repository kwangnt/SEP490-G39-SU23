package com.teachsync.controllers;

import com.teachsync.entities.Question;
import com.teachsync.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
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
                                  @RequestParam("question-type") String questionType,
                                  @RequestParam Map<String, String> requestParams) {

        List<Question> lst= new ArrayList<>();
        if (questionType.equals("essay")) {
            for (int i = 1; i <= numQuestions; i++) {
                Question question = new Question();
                question.setQuestion(requestParams.get("essayQuestion" + i));
                questionRepository.save(question);
            }

        } else if (questionType.equals("multipleChoice")){

        }



        // Redirect to a success page or do any other necessary actions

        return "redirect:/success";
    }
}
