package com.examFeb.web;

import com.examFeb.binding.UserLoginBindingModel;
import com.examFeb.binding.UserRegisterBindingModel;
import com.examFeb.model.service.UserServiceModel;
import com.examFeb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("user") != null) {
            return "redirect:/";
        }
        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }

        return "register";

    }

    @GetMapping("/login")
    public String getLoginPage(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) {
            return "redirect:/";
        }
        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            model.addAttribute("notFound", false);
        }

        return "login";
    }

    @PostMapping("/register")
    public String postRegister(@Valid UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }

        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:/users/login";
    }

    @PostMapping("/login")
    public String postLogin(@Valid UserLoginBindingModel userLoginBindingModel,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes,
                            HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute
                    ("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);
            httpSession.setAttribute("username", userLoginBindingModel.getUsername());


            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService.findByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        if (userServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login";
        }
        httpSession.setAttribute("user", userServiceModel);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String userLogout(HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }
        httpSession.invalidate();
        return "index";
    }
}
