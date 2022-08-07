package megafon.internship.controllers.rest;

import megafon.internship.dao.UserDAO;
import megafon.internship.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserAPI {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/users", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UserDAO> users() {
        return usersService.getAllUsersDAO();
    }


    @RequestMapping(value = "/users/admin", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UserDAO> adminUsers() {
        return usersService.getAdminUsersDAO();
    }


    @RequestMapping(value = "/users/manager", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UserDAO> managerUsers() {
        return usersService.getManagerUsersDAO();
    }


    @RequestMapping(value = "/users/mentor", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UserDAO> mentorUsers() {
        return usersService.getMentorUsersDAO();
    }


    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> deleteUser(@PathVariable String userId) {
        usersService.deleteUser(Long.parseLong(userId));
        Map<String, String> responseMessage = new HashMap<>();
        responseMessage.put("message", "user with id:" + userId + " is deleted");
        return responseMessage;
    }

}
