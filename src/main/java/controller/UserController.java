package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import service.UserServiceImpl;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public String allUsers(Model model) {
     List<User> users = userService.getUsersList();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "/new_user";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/new_user";
        }

        userService.addUser(user);
        return "redirect:/users";
    }
    @GetMapping("/edit")
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        User userById = userService.getUser(id);

        if (userById != null) {
            model.addAttribute("user", userById);
            return "/edit_user";
        } else {
            return "/users";
        }
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/edit_user";
        }

        userService.editUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}