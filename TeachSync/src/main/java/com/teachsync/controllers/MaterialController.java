package com.teachsync.controllers;

import com.teachsync.dtos.material.MaterialReadDTO;
import com.teachsync.dtos.user.UserReadDTO;

import com.teachsync.entities.Material;
import com.teachsync.entities.User;
import com.teachsync.repositories.MaterialRepository;
import com.teachsync.repositories.UserRepository;
import com.teachsync.services.Material.MaterialService;
import com.teachsync.utils.enums.Status;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MaterialController {

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MaterialService materialService;

    @GetMapping("/creatematerial")
    public String createNews(Model model, HttpSession session) {
        UserReadDTO user = (UserReadDTO) session.getAttribute("loginUser");
        if (user == null || user.getRoleId() != 1) {
            return "redirect:/";
        } else return "create-material";
    }

//    @PostMapping("/submitcreatematerial")
//    public String submitCreateNews(Model model, HttpSession session,
//                                   @RequestParam String ,
//                                   @RequestParam String ,
//                                   @RequestParam String ) {
//
//        UserReadDTO user = (UserReadDTO) session.getAttribute("loginUser");
//        if (user == null || user.getRoleId() != 1) {
//            return "redirect:/";
//        }
//        System.out.println("user id = " + user.getId());
//
//        User user1 = userRepository.findById(user.getId()).orElse(null);
//
//        Material material = new Material(, , , , , Status.CREATED);
//
//        materialRepository.save(material);
//        return "redirect:/";
//    }


    @GetMapping("/editmaterial")
    public String editNews(Model model, HttpSession session,
                           @RequestParam String id) {

        UserReadDTO user = (UserReadDTO) session.getAttribute("loginUser");
        if (user == null || user.getRoleId() != 1) {
            return "redirect:/";
        }
        System.out.println("user id = " + user.getId());


        Material material = materialRepository.findAllById(Long.parseLong(id));
        model.addAttribute("material", material);
        return "edit-material";
    }

//    @PostMapping("/submiteditnews")
//    public String submitEditNews(Model model, HttpSession session,
//                                 @RequestParam String ,
//                                 @RequestParam String ,
//                                 @RequestParam String ,
//                                 @RequestParam String ) {
//
//        UserReadDTO user = (UserReadDTO) session.getAttribute("loginUser");
//        if (user == null || user.getRoleId() != 1) {
//            return "redirect:/";
//        }
//        System.out.println("user id = " + user.getId());
//
//        User user1 = userRepository.findById(user.getId()).orElse(null);
//
//        Material material = new Material(, , , , , , Status.UPDATED);
//
//        materialRepository.save(material);
//        return "redirect:/";
//    }


    @GetMapping("/material")
    public String news(Model model) {

        try {
            Page<MaterialReadDTO> dtoPage = materialService.getPageDTOAll(null);

            if (dtoPage != null) {
                model.addAttribute("newsList", dtoPage.getContent());
                model.addAttribute("pageNo", dtoPage.getPageable().getPageNumber());
                model.addAttribute("pageTotal", dtoPage.getTotalPages());

            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", "Server error, please try again later");
        }
        return "list-material";
    }

    @GetMapping("/material-detail")
    public String getDetailById(
            @RequestParam Long id,
            Model model) {
        try {
            MaterialReadDTO material = materialService.getDTOById(id);

            if (material == null) {
                /* Not found by Id */
                return "redirect:/material";
            }

            model.addAttribute("material", material);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", "Server error, please try again later");
        }

        return "material-detail";
    }
}
