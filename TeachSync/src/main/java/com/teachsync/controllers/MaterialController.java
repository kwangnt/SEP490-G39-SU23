package com.teachsync.controllers;

import com.teachsync.dtos.material.MaterialCreateDTO;
import com.teachsync.dtos.material.MaterialReadDTO;
import com.teachsync.dtos.user.UserReadDTO;

import com.teachsync.entities.Material;
import com.teachsync.entities.User;
import com.teachsync.repositories.MaterialRepository;
import com.teachsync.repositories.UserRepository;
import com.teachsync.services.Material.MaterialService;
import com.teachsync.utils.enums.MaterialType;
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
import static com.teachsync.utils.enums.PromotionType.AMOUNT;
import static com.teachsync.utils.enums.PromotionType.PERCENT;

@Controller
public class MaterialController {

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MaterialService materialService;

    @GetMapping("/create-material")
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

    @PostMapping("/create-material")
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
        materialDTO.setMaterialName(request.getParameter("name"));

        materialDTO.setMaterialLink(request.getParameter("link"));
        materialDTO.setMaterialContent(new byte[]{Byte.parseByte(request.getParameter("content"))});
        //TODO : process upload file
        materialDTO.setMaterialImg("https://th.bing.com/th/id/OIP.R7Wj-CVruj2Gcx-MmaxmZAHaKe?pid=ImgDet&rs=1");
        materialDTO.setMaterialType(MaterialType.valueOf(request.getParameter("type")));
        materialDTO.setFree(Boolean.parseBoolean(request.getParameter("free")));


        try {
            materialService.addMaterial(materialDTO, userDTO.getId());
        } catch (Exception e) {
            model.addAttribute("mess", "Lỗi : " + e.getMessage());
            return "create-material";
        }

        redirect.addAttribute("mess", "Tạo mới tài liệu thành công");
        return "redirect:/material";
    }


    @GetMapping("/edit-material")
    public String editNews(Model model, HttpServletRequest request, RedirectAttributes redirect) throws Exception{
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
        Long Id = Long.parseLong(request.getParameter("id"));
        MaterialReadDTO material = materialService.getDTOById(Id);
        model.addAttribute("material", material);

        return "edit-material";
    }

    @PostMapping("/edit-material")
    public String submitEditMaterial(Model model, HttpServletRequest request, RedirectAttributes redirect ) {
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
        MaterialReadDTO materialReadDTO = new MaterialReadDTO();
        materialReadDTO.setId(Long.parseLong(request.getParameter("id")));
        materialReadDTO.setMaterialName(request.getParameter("name"));
        //TODO : process upload file
        materialReadDTO.setMaterialLink(request.getParameter("link"));
        materialReadDTO.setMaterialContent(new byte[]{Byte.parseByte(request.getParameter("content"))});
        materialReadDTO.setMaterialImg("https://th.bing.com/th/id/OIP.R7Wj-CVruj2Gcx-MmaxmZAHaKe?pid=ImgDet&rs=1");
        materialReadDTO.setMaterialType(MaterialType.valueOf(request.getParameter("type")));
        materialReadDTO.setIsFree(Boolean.parseBoolean(request.getParameter("free")));

        try {
            materialService.editMaterial(materialReadDTO, userDTO.getId());
        } catch (Exception e) {
            model.addAttribute("mess", "Lỗi : " + e.getMessage());
            return "edit-material";
        }

        redirect.addAttribute("mess", "Sửa khóa học thành công");

        return "redirect:/material";
    }


    @GetMapping("/material")
    public String material(Model model, @ModelAttribute("mess") String mess) {

        try {
            Page<MaterialReadDTO> dtoPage = materialService.getPageDTOAll(null);

            if (dtoPage != null) {
                model.addAttribute("materialList", dtoPage.getContent());
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
