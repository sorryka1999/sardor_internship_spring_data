package megafon.internship.controllers;

import megafon.internship.services.RolesService;
import megafon.internship.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RolesService rolesService;

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("users", usersService.getAllUsers());
        return "user";
    }

    @PostMapping("/user/add")
    public String addUser(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String age,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role
    ) {
        if (!usersService.doesEmailExist(email)) {
            usersService.addUser(name, surname, age, email, password, role);
        }
        return "redirect:/user";
    }

    @GetMapping("/user/edit/{userId}")
    public String userEdit(
            @PathVariable String userId,
            Model model
    ) {
        model.addAttribute("user", usersService.getUserById(Long.parseLong(userId)));
        return "userEdit";
    }

    @PostMapping("/user/edit/{userId}/change-status")
    public String changeUserStatus(
            @PathVariable String userId
    ) {
        usersService.changeStatus(Long.parseLong(userId));
        return "redirect:/user/edit/" + userId;
    }

    @PostMapping("/user/edit/{userId}/delete")
    public String deleteUser(
            @PathVariable String userId
    ) {
        usersService.deleteUser(Long.parseLong(userId));
        return "redirect:/user";
    }

    @PostMapping("/user/edit/{userId}/update")
    public String updateUser(
            @PathVariable String userId,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String age,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role
    ) {
        if (!usersService.doesEmailExist(email)) {
            usersService.updateUser(Long.parseLong(userId), name, surname, age, email, password, role);
        }
        return "redirect:/user";
    }

}
