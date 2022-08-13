package megafon.internship.controllers;

import com.google.gson.Gson;
import megafon.internship.entity.Interns;
import megafon.internship.entity.Users;
import megafon.internship.services.InternsService;
import megafon.internship.services.UsersService;
import megafon.internship.services.mongo.MentorTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class InternTaskController {

    @Autowired
    private InternsService internsService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private MentorTaskService mentorTaskService;

    @GetMapping("/intern/tasks/all")
    public String internAllTasks(Model model) {
        Gson gson = new Gson();
        String jsonTasks = gson.toJson(mentorTaskService.getAllTasks());
        model.addAttribute("tasks", jsonTasks);
        return "internAllTasks";
    }

    @GetMapping("/intern/tasks/{internId}")
    public String internTasks(
            @PathVariable(name = "internId") String stringInternId,
            Model model
    ) {
        long internId = Long.parseLong(stringInternId);
        Interns intern = internsService.getInternById(internId);
        model.addAttribute("intern", intern);
        model.addAttribute("tasks", mentorTaskService.getExecutorTasks(internId));
        return "internTasks";
    }

    @PostMapping("/intern/{internId}/tasks/add")
    public String addTask(
            @PathVariable(name = "internId") String stringInternId,
            @RequestParam String taskDescription
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users userCreatedTask = (Users) authentication.getPrincipal();
        long userCreatedTaskId = userCreatedTask.getId();
        mentorTaskService.createTask(
                userCreatedTaskId, Long.parseLong(stringInternId),
                taskDescription, LocalDate.now());
        return "redirect:/intern/tasks/" + stringInternId;
    }

    @PostMapping("/intern/{internId}/task/{taskId}/delete")
    public String deleteTask(
            @PathVariable(name = "internId") String stringInternId,
            @PathVariable(name = "taskId") String stringTaskId
    ) {
        mentorTaskService.deleteTask(stringTaskId);
        return "redirect:/intern/tasks/" + stringInternId;
    }
}
