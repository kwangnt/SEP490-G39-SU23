package com.teachsync.controllers;

import com.teachsync.dtos.user.UserReadDTO;
import com.teachsync.entities.News;
import com.teachsync.repositories.NewsRepository;
import com.teachsync.utils.enums.Status;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewsController {
    @Autowired
    NewsRepository newsRepository;

    @GetMapping("/createnews")
    public String createNews(Model model, HttpSession session) {
        UserReadDTO user = (UserReadDTO) session.getAttribute("loginUser");
        if (user == null || user.getRoleId() != 1) {
            return "redirect:/";
        } else return "create-news";
    }

    @PostMapping("/submitcreatenews")
    public String submitCreateNews(Model model, HttpSession session,
                                   @RequestParam String title,
                                   @RequestParam String description,
                                   @RequestParam String content) {

        UserReadDTO user = (UserReadDTO) session.getAttribute("loginUser");
        if (user == null || user.getRoleId() != 1) {
            return "redirect:/";
        }
        System.out.println("user id = " + user.getId());

        News news = new News(title, description, content, user.getId(), Status.CREATED);

        newsRepository.save(news);
        return "news";
    }


    @PostMapping("/editnews")
    public String editNews(Model model, HttpSession session,
                           @RequestParam String id) {

        UserReadDTO user = (UserReadDTO) session.getAttribute("loginUser");
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
                                 @RequestParam String id,
                                 @RequestParam String title,
                                 @RequestParam String description,
                                 @RequestParam String content) {

        UserReadDTO user = (UserReadDTO) session.getAttribute("loginUser");
        if (user == null || user.getRoleId() != 1) {
            return "redirect:/";
        }
        System.out.println("user id = " + user.getId());

        News news = new News(Long.parseLong(id), title, description, content, user.getId(), Status.UPDATED);

        newsRepository.save(news);
        return "news";
    }


    @GetMapping("/news")
    public String news() {
        return "list-news";
    }
}
