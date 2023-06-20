package com.teachsync.controllers;

import com.teachsync.dtos.user.UserReadDTO;
import com.teachsync.entities.News;
import com.teachsync.entities.User;
import com.teachsync.repositories.NewsRepository;
import com.teachsync.repositories.UserRepository;
import com.teachsync.utils.enums.Status;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class NewsController {
    @Autowired
    NewsRepository newsRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/createnews")
    public String createNews(Model model, HttpSession session) {
        UserReadDTO user = (UserReadDTO) session.getAttribute("user");
        if (user == null || user.getRoleId() != 1) {
            return "redirect:/";
        } else return "create-news";
    }

    @PostMapping("/submitcreatenews")
    public String submitCreateNews(Model model, HttpSession session,
                                   @RequestParam String title,
                                   @RequestParam String description,
                                   @RequestParam String content) {

        UserReadDTO user = (UserReadDTO) session.getAttribute("user");
        if (user == null || user.getRoleId() != 1) {
            return "redirect:/";
        }
        System.out.println("user id = " + user.getId());

        User user1 = userRepository.findById(user.getId()).orElse(null);

        News news = new News(user1.getId(), title, null, content, description);
        news.setStatus(Status.CREATED);

        newsRepository.save(news);
        return "redirect:/";
    }


    @GetMapping("/editnews")
    public String editNews(Model model, HttpSession session,
                           @RequestParam String id) {

        UserReadDTO user = (UserReadDTO) session.getAttribute("user");
        if (user == null || user.getRoleId() != 1) {
            return "redirect:/";
        }
        System.out.println("user id = " + user.getId());


        News news = newsRepository.findAllById(Long.parseLong(id));
        model.addAttribute("news", news);
        return "edit-news";
    }

    @PostMapping("/submiteditnews")
    public String submitEditNews(Model model, HttpSession session,
                                 @RequestParam String idNews,
                                 @RequestParam String title,
                                 @RequestParam String description,
                                 @RequestParam String content) {

        UserReadDTO user = (UserReadDTO) session.getAttribute("user");
        if (user == null || user.getRoleId() != 1) {
            return "redirect:/";
        }
        System.out.println("user id = " + user.getId());

        User user1 = userRepository.findById(user.getId()).orElse(null);

        News news = new News(user1.getId(), title, null, content, description);
        news.setId(Long.parseLong(idNews));
        news.setStatus(Status.UPDATED);

        newsRepository.save(news);
        return "redirect:/";
    }


    @GetMapping("/news")
    public String news() {
        return "list-news";
    }
}
