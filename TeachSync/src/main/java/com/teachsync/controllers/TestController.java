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
import com.teachsync.utils.Constants;
import com.teachsync.utils.enums.QuestionType;
import com.teachsync.utils.enums.Status;
import com.teachsync.utils.enums.TestType;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
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
        UserReadDTO user = (UserReadDTO) session.getAttribute("user");
        if (user == null || !user.getRoleId().equals(Constants.ROLE_ADMIN)) {
            return "redirect:/";
        }
        List<Course> lst = courseRepository.findAllByStatusNot(Status.DELETED);
        model.addAttribute("lstCourse", lst);
        return "create-test";
    }


    @PostMapping("/process-question")
    public String processQuestion(Model model, HttpSession session,
                                  @RequestParam("courseName") String courseName,
                                  @RequestParam("testType") TestType testType,
                                  @RequestParam("timeLimit") int timeLimit,
                                  @RequestParam("numQuestions") int numQuestions,
                                  @RequestParam("questionType") String questionType,
                                  @RequestParam Map<String, String> requestParams) {
        UserReadDTO user = (UserReadDTO) session.getAttribute("user");
        if (user == null || !user.getRoleId().equals(Constants.ROLE_ADMIN)) {
            return "redirect:/";
        }
        LocalDateTime currentDate = LocalDateTime.now();

        Test test = new Test();
        test.setCourseId(Long.parseLong(courseName));
        test.setTestName("");
        test.setTestType(testType);
        test.setNumQuestion(numQuestions);
        test.setTimeLimit(timeLimit);

        switch (testType) {
            case FIFTEEN_MINUTE -> {
                test.setMinScore(1.0);
                test.setTestWeight(1);
            }

            case MIDTERM -> {
                test.setMinScore(1.0);
                test.setTestWeight(3);
            }

            case FINAL -> {
                test.setMinScore(4.0);
                test.setTestWeight(5);
            }
        }

        test.setStatus(Status.CREATED);
        Test rsTest = testRepository.save(test);

        if (questionType.equals("essay")) {
            for (int i = 1; i <= numQuestions; i++) {
                Question question = new Question();
                question.setTestId(rsTest.getId());
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
                question.setTestId(rsTest.getId());
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


    @GetMapping("/edit-test")
    public String editTestView(Model model, HttpSession session, @RequestParam("id") String idTest) {
//        UserReadDTO user = (UserReadDTO) session.getAttribute("user");
//        if (user == null || user.getRoleId() != 1) {
//            return "redirect:/";
//        }

        Test test = testRepository.findAllById(Collections.singleton(Long.parseLong(idTest))).get(0);
        List<Question> lstQuestion = questionRepository.findAllByTestId(test.getId());
        HashMap<Question, List<Answer>> hm = new HashMap<>();
        for (Question qs : lstQuestion) {
            hm.put(qs, answerRepository.findAllByQuestionId(qs.getId()));
        }
        List<Course> lst = courseRepository.findAllByStatusNot(Status.DELETED);
        model.addAttribute("lstCourse", lst);

        model.addAttribute("test", test);

        model.addAttribute("questionAnswer", hm);
        System.out.println("size cua hashmap: " + hm.size());
        return "edit-test";

    }

    @PostMapping("/updateAnswer")
    public String updateAnswer(Model model, HttpSession session,
                               @RequestParam("courseName") String courseName,
                               @RequestParam("idTest") String idTest,
                               @RequestParam("idQuestion") String idQuestion,
                               @RequestParam("testType") String testType,
                               @RequestParam("timeLimit") int timeLimit,
                               @RequestParam("numQuestions") int numQuestions,
                               @RequestParam("questionType") String questionType,
                               @RequestParam Map<String, String> requestParams) {
//        UserReadDTO user = (UserReadDTO) session.getAttribute("user");
//        if (user == null || user.getRoleId() != 1) {
//            return "redirect:/";
//        }
        LocalDateTime currentDate = LocalDateTime.now();

        Test test = testRepository.findById(Long.parseLong(idTest)).orElse(null);
        test.setTestName(testType);
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
        test.setStatus(Status.UPDATED);
        test.setTimeLimit(timeLimit);
        test.setCourseId(Long.parseLong(courseName));
        testRepository.save(test);

        Question question = questionRepository.findById(Long.parseLong(idQuestion)).orElse(null);
        question.setQuestionDesc(requestParams.get("questionAll"));

        if (questionType.equals("multipleChoice")) {
            answerRepository.deleteAllByQuestionId(question.getId());
            int numAnswer = Integer.parseInt(requestParams.get("numOfOptions"));
            for (int i = 1; i < numAnswer; i++) {
                Answer answer = new Answer();
                answer.setQuestionId(question.getId());
                answer.setAnswerDesc(requestParams.get("answer" + i));
                answer.setIsCorrect(requestParams.get("correctAnswer" + i) != null);
                answer.setStatus(Status.UPDATED);
                answer.setCreatedAt(currentDate);
//                answer.setCreatedBy(user.getId());
                answerRepository.save(answer);
            }
        }

        // Redirect to a success page or do any other necessary actions

        return "redirect:/";
    }
}
