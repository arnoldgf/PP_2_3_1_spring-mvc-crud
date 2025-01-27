package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import web.service.UserService;
import web.model.User;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	public void someMethod() {
		logger.info("This is a log message!");
	}

	@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
	}

	@GetMapping
	public String Users(ModelMap model) {
		logger.info("Fetching list of users"); //logger
		logger.debug("Some debug message");

		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "users";
	}

	@GetMapping("/new")
	public String newUser(@ModelAttribute("user") User user) {
		return "new";
	}
	
	@PostMapping("/new")
	public String create(@ModelAttribute("user") User user) {
		logger.info("Creating a new user: {}", user); //logger
		logger.debug("Some debug message");

		userService.saveUser(user);
		return "redirect:/users";
	}

	@GetMapping("/id")
	public String user(@RequestParam("id") int id, ModelMap model) {
		model.addAttribute("user", userService.getUser(id));
		return "user";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") int id, ModelMap model) {
		model.addAttribute("user", userService.getUser(id));
		return "edit";
	}

	@PostMapping("/edit")
	public String update(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam int id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
}