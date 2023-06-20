package com.teachsync.controllers;

import com.teachsync.dtos.user.UserReadDTO;
import com.teachsync.entities.Answer;
import com.teachsync.entities.Question;
import com.teachsync.repositories.AnswerRepository;
import com.teachsync.repositories.QuestionRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;

    @PostMapping("/process-question")
    public String processQuestion(Model model, HttpSession session,
                                  @RequestParam("numQuestions") int numQuestions,
                                  @RequestParam("question-type") String questionType,
                                  @RequestParam Map<String, String> requestParams) {
        UserReadDTO user = (UserReadDTO) session.getAttribute("loginUser");
        if (user == null || user.getRoleId() != 1) {
            return "redirect:/";
        }

        if (questionType.equals("essay")) {
            for (int i = 1; i <= numQuestions; i++) {
                Question question = new Question();
                question.setQuestion(requestParams.get("essayQuestion" + i));
                questionRepository.save(question);
            }

        } else if (questionType.equals("multipleChoice")) {
            for (int i = 1; i <= numQuestions; i++) {
                int numAnswer = Integer.parseInt(requestParams.get("numOptions" + i));
                Question question = new Question();
                question.setQuestion(requestParams.get("multipleChoiceQuestion" + i));
                Question result = questionRepository.save(question);
                for (int j = 0; j < numAnswer; j++) {
                    Answer answer = new Answer();
                    answer.setQuestionId(result.getId());
                    answer.setAnswerDesc(requestParams.get("answer" + i + "-" + j));
                    answer.setCorrect(requestParams.get("isCorrect" + i + "-" + j) != null);
                    answer.setStatus("CREATED");
                    Date currentDate = new Date();
                    answer.setCreatedAt(currentDate);
                    answer.setCreatedBy(user.getId());
                    answerRepository.save(answer);
                }
            }
        }


        // Redirect to a success page or do any other necessary actions

        return "redirect:/success";
    }
}
