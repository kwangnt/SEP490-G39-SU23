package com.teachsync.controllers;

import com.teachsync.dtos.material.MaterialCreateDTO;
import com.teachsync.dtos.material.MaterialReadDTO;
import com.teachsync.dtos.user.UserReadDTO;

import com.teachsync.entities.Material;
import com.teachsync.entities.User;
import com.teachsync.repositories.MaterialRepository;
import com.teachsync.repositories.UserRepository;
import com.teachsync.services.Material.MaterialService;
import com.teachsync.utils.enums.Status;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.teachsync.utils.Constants.ROLE_ADMIN;

@Controller
public class MaterialController {

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MaterialService materialService;

    @GetMapping("/creatematerial")
    public String createMaterial(HttpServletRequest request, RedirectAttributes redirect) {
        HttpSession session = request.getSession();

        UserReadDTO userDTO = (UserReadDTO) session.getAttribute("user");
        if (ObjectUtils.isEmpty(userDTO)) {
            redirect.addAttribute("mess", "Làm ơn đăng nhập");
            return "redirect:/";
        }

        if (!userDTO.getRoleId().equals(ROLE_ADMIN)) {
            redirect.addAttribute("mess", "Bạn không đủ quyền");
            return "redirect:/";
        }

        return "create-material";
    }

    @PostMapping("/submitcreatematerial")
    public String submitCreateMaterial(Model model, HttpServletRequest request, RedirectAttributes redirect) {

        HttpSession session = request.getSession();
        if (ObjectUtils.isEmpty(session.getAttribute("user"))) {
            redirect.addAttribute("mess", "Làm ơn đăng nhập");
            return "redirect:/";
        }
        UserReadDTO userDTO = (UserReadDTO) session.getAttribute("user");
        if (!userDTO.getRoleId().equals(ROLE_ADMIN)) {
            redirect.addAttribute("mess", "Bạn không đủ quyền");
            return "redirect:/";
        }

        /* Thay = modelAttr or json (RequestBody) */
        MaterialCreateDTO materialDTO = new MaterialCreateDTO();
        materialDTO.materialName(request.getParameter("name"));
        //TODO : process upload file
        materialDTO.setMaterialLink(request.getParameter("link"));
        materialDTO.materialName(Byte.parseByte(request.getParameter("content")));
        materialDTO.setMaterialImg("https://th.bing.com/th/id/OIP.R7Wj-CVruj2Gcx-MmaxmZAHaKe?pid=ImgDet&rs=1");


        try {
            materialDTO.(courseDTO, userDTO.getId());
        } catch (Exception e) {
            model.addAttribute("mess", "Lỗi : " + e.getMessage());
            return "add-course";
        }

        redirect.addAttribute("mess", "Tạo mới khóa học thành công");
        return "redirect:/course";
    }


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

//    @PostMapping("/submiteditmaterial")
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
    public String material(Model model, @ModelAttribute("mess") String mess) {

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
        model.addAttribute("mess", mess);

        return "list-material";
    }

    @GetMapping("/material-detail")
    public String getDetailById(
            @RequestParam(name = "id") Long courseId,
            Model model) {
        try {
            MaterialReadDTO material = materialService.getDTOById(courseId);

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
