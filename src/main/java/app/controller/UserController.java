package app.controller;

import app.model.User;
import app.service.UserService;
import app.service.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
private final UserServiceInt userService;

@Autowired
    public UserController(UserServiceInt userService) {
        this.userService = userService;
    }

    @GetMapping
    public String Users(ModelMap model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String newUser (@ModelAttribute("user") User user){
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/id")
    public String user(@RequestParam("id") int id, ModelMap model){
        // получим одного человека по его id из сервиса
        // и передадим этого человека на отображение в представление
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, ModelMap model){
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        userService.deleteUsers(id);
        return "redirect:/users";
    }

}
