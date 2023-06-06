//package com.teachsync.TeachSync.controllers;
//
//import com.teachsync.TeachSync.entities.User;
//import com.teachsync.TeachSync.entities.Utility;
//import com.teachsync.TeachSync.services.UserService;
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import jakarta.servlet.http.HttpServletRequest;
//import org.modelmapper.internal.bytebuddy.utility.RandomString;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.io.UnsupportedEncodingException;
//
//@Controller
//public class ForgotPasswordController {
//    @Autowired
//    private JavaMailSender mailSender;
//
//
//
//    @GetMapping("/forgot_password")
//    public String showForgotPasswordForm() {
//        return "forgot_password_form";
//    }
//
////    @PostMapping("/forgot_password")
////    public String processForgotPassword(HttpServletRequest request, Model model) {
////        String email = request.getParameter("email");
////        String token = RandomString.make(30);
////
////        try {
////            .updateResetPasswordToken(token, email);
////            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
////            sendEmail(email, resetPasswordLink);
////            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
////
////        } catch ( ex) {
////            model.addAttribute("error", ex.getMessage());
////        } catch (UnsupportedEncodingException |  e) {
////            model.addAttribute("error", "Error while sending email");
////        }
////
////        return "forgot_password";
////    }
////
////    public void sendEmail(String recipientEmail, String link)
////            throws MessagingException, UnsupportedEncodingException{
////        MimeMessage message = mailSender.createMimeMessage();
////        MimeMessageHelper helper = new MimeMessageHelper(message);
////
////        helper.setFrom("contact@shopme.com", "Shopme Support");
////        helper.setTo(recipientEmail);
////
////        String subject = "Here's the link to reset your password";
////
////        String content = "<p>Hello,</p>"
////                + "<p>You have requested to reset your password.</p>"
////                + "<p>Click the link below to change your password:</p>"
////                + "<p><a href=\"" + link + "\">Change my password</a></p>"
////                + "<br>"
////                + "<p>Ignore this email if you do remember your password, "
////                + "or you have not made the request.</p>";
////
////        helper.setSubject(subject);
////
////        helper.setText(content, true);
////
////        mailSender.send(message);
////    }
////
////
////    @GetMapping("/reset_password")
////    public String showResetPasswordForm() {
////        User user = UserService.getByResetPasswordToken(token);
////        model.addAttribute("token", token);
////
////        if (user == null) {
////            model.addAttribute("message", "Invalid Token");
////            return "message";
////        }
////
////        return "reset_password_form";
////    }
////
////    @PostMapping("/reset_password")
////    public String processResetPassword() {
////        String token = request.getParameter("token");
////        String password = request.getParameter("password");
////
////        Customer customer = customerService.getByResetPasswordToken(token);
////        model.addAttribute("title", "Reset your password");
////
////        if (customer == null) {
////            model.addAttribute("message", "Invalid Token");
////            return "message";
////        } else {
////            customerService.updatePassword(customer, password);
////
////            model.addAttribute("message", "You have successfully changed your password.");
////        }
////
////        return "message";
////    }
//}
