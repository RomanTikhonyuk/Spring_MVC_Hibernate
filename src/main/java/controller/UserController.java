package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        List<User> users = service.getUsersList();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String showFormAddUser(Model model) {
        model.addAttribute("user", new User());
        return "new_user";
    }


    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String updateUserForm(Model model, @RequestParam("id") Long id) {
        model.addAttribute("user", service.getUser(id));
        return "edit_user";
    }

    @PatchMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        service.editUser(user);
        return "redirect:/users";
    }

    @DeleteMapping()
    public String deleteUser(@ModelAttribute("user") User user) {
        service.deleteUser(user.getId());
        return "redirect:/users";
    }

}