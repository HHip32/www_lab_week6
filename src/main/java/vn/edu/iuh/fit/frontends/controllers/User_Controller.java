package vn.edu.iuh.fit.frontends.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backends.models.User;
import vn.edu.iuh.fit.backends.repositories.User_Repository;
import vn.edu.iuh.fit.backends.services.User_Service;

@Controller
@RequestMapping("/users")
@NoArgsConstructor
@AllArgsConstructor
public class User_Controller {
    private User_Repository userRepository;
    private User_Service userService;

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") String id) {
        return "";
    }

    @GetMapping("/add-form")
    public String show(@ModelAttribute User user, Model model) {
        user = new User();
        model.addAttribute("user", user);
        return "users/add-form";
    }

    //    @PostMapping("/")
//    public String add(@ModelAttribute User user, Model model) {
//        userRepository.save(user);
//        return "/";
//    }

    @GetMapping("/show-login-page")
    public String show_login(@ModelAttribute User user, Model model) {
        model.addAttribute("user", new User());
        return "users/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        User user1 = userService.login(user.getEmail(), user.getPasswordHash());
        model.addAttribute("userLogin", user1);
        return "index";
    }


}
