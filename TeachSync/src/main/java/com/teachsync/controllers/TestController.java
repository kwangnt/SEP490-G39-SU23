package com.teachsync.controllers;

import com.teachsync.dtos.user.UserReadDTO;
import com.teachsync.entities.Answer;
import com.teachsync.entities.Course;
import com.teachsync.entities.Question;
import com.teachsync.entities.Test;
import com.teachsync.repositories.AnswerRepository;
import com.teachsync.repositories.CourseRepository;
import com.teachsync.repositories.QuestionRepository;
import com.teachsync.repositories.TestRepository;
import com.teachsync.utils.enums.QuestionType;
import com.teachsync.utils.enums.Status;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    TestRepository testRepository;

    @GetMapping("/create-test")
    public String createTestViews(Model model, HttpSession session) {
        UserReadDTO user = (UserReadDTO) session.getAttribute("loginUser");
        if (user == null || user.getRoleId() != 1) {
            return "redirect:/";
        }
        List<Course> lst = courseRepository.findAllByStatusNot(Status.DELETED);
        model.addAttribute("lstCourse", lst);
        return "create-test";
    }


    @PostMapping("/process-question")
    public String processQuestion(Model model, HttpSession session,
                                  @RequestParam("courseName") String courseName,
                                  @RequestParam("testType") String testType,
                                  @RequestParam("timeLimit") int timeLimit,
                                  @RequestParam("numQuestions") int numQuestions,
                                  @RequestParam("questionType") String questionType,
                                  @RequestParam Map<String, String> requestParams) {
        UserReadDTO user = (UserReadDTO) session.getAttribute("loginUser");
        if (user == null || user.getRoleId() != 1) {
            return "redirect:/";
        }
        LocalDateTime currentDate = LocalDateTime.now();

        Test test = new Test();
        test.setCourseId(Long.parseLong(courseName));
        test.setTestName(testType);
        test.setTestType(testType);
        test.setTimeLimit(timeLimit);
        if (testType.equals("15min")) {
            test.setMinScore(1.0);
            test.setTestWeight(1);
        } else if (testType.equals("midterm")) {
            test.setMinScore(1.0);
            test.setTestWeight(3);
        } else {
            test.setMinScore(4.0);
            test.setTestWeight(5);
        }
        test.setStatus(Status.CREATED);
        testRepository.save(test);

        if (questionType.equals("essay")) {
            for (int i = 0; i < numQuestions; i++) {
                Question question = new Question();
                question.setQuestionDesc(requestParams.get("essayQuestion" + i));
                question.setQuestionType(QuestionType.ESSAY);
                question.setStatus(Status.CREATED);

                question.setCreatedAt(currentDate);
                question.setCreatedBy(user.getId());
                questionRepository.save(question);
            }

        } else if (questionType.equals("multipleChoice")) {
            for (int i = 0; i < numQuestions; i++) {
                int numAnswer = Integer.parseInt(requestParams.get("numOptions" + i));
                Question question = new Question();
                question.setQuestionDesc(requestParams.get("multipleChoiceQuestion" + i));
                question.setQuestionType(QuestionType.MULTIPLE);
                question.setStatus(Status.CREATED);
                question.setCreatedAt(currentDate);
                question.setCreatedBy(user.getId());
                Question result = questionRepository.save(question);
                for (int j = 0; j < numAnswer; j++) {
                    Answer answer = new Answer();
                    answer.setQuestionId(result.getId());
                    answer.setAnswerDesc(requestParams.get("answer" + i + "-" + j));
                    answer.setIsCorrect(requestParams.get("isCorrect" + i + "-" + j) != null);
                    answer.setStatus(Status.CREATED);
                    answer.setCreatedAt(currentDate);
                    answer.setCreatedBy(user.getId());
                    answerRepository.save(answer);
                }
            }
        }


        // Redirect to a success page or do any other necessary actions

        return "redirect:/";
    }
}
