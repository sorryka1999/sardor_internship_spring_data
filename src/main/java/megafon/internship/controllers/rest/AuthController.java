package megafon.internship.controllers.rest;

import megafon.internship.dao.UserDAO;
import megafon.internship.entity.Users;
import megafon.internship.services.UsersService;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class AuthController {

    private UsersService usersService;

    public AuthController(UsersService service) {
        this.usersService = service;
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDAO getAuthUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        Users user = (principal instanceof Users) ? (Users) principal : null;
        return Objects.nonNull(user) ? this.usersService.getUserDAOByEmail(user.getUsername()) : null;
    }

}
