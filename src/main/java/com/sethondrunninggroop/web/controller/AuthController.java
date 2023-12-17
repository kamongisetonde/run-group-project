package com.sethondrunninggroop.web.controller;

import com.sethondrunninggroop.web.dto.UserDto;
import com.sethondrunninggroop.web.models.User;
import com.sethondrunninggroop.web.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;

    private final JavaMailSender emailSender;

    public AuthController(UserService userService, JavaMailSender emailSender) {
        this.userService = userService;
        this.emailSender = emailSender;
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("kamongisethonde@gmail.com");
        mailMessage.setTo(userDto.getEmail());
        mailMessage.setSubject("Welcome to the Running Club Home!");
        mailMessage.setText("Congratulation !! You are welcome to the official running club app. Feel at home and keep watch on your email for future events!!");
        emailSender.send(mailMessage);

        return "redirect:/register?success";
    }
}
