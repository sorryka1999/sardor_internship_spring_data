package megafon.internship.controllers;

import com.google.gson.Gson;
import megafon.internship.entity.Employees;
import megafon.internship.entity.Users;
import megafon.internship.services.EmployeesService;
import megafon.internship.services.UsersService;
import megafon.internship.services.mongo.ManagerTaskService;
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
public class EmployeeTaskController {

    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private ManagerTaskService managerTaskService;

    @GetMapping("/employee/tasks/all")
    public String employeeAllTasks(Model model) {
        Gson gson = new Gson();
        String jsonTasks = gson.toJson(managerTaskService.getAllTasks());
        model.addAttribute("tasks", jsonTasks);
        return "employeeAllTasks";
    }

    @GetMapping("/employee/tasks/{employeeId}")
    public String employeeTasks(
            @PathVariable(name = "employeeId") String stringEmployeeId,
            Model model
    ) {
        long employeeId = Long.parseLong(stringEmployeeId);
        Employees employee = employeesService.getEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        model.addAttribute("tasks", managerTaskService.getExecutorTasks(employeeId));
        return "employeeTasks";
    }

    @PostMapping("/employee/{employeeId}/tasks/add")
    public String addTask(
            @PathVariable(name = "employeeId") String stringEmployeeId,
            @RequestParam String taskDescription
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users userCreatedTask = (Users) authentication.getPrincipal();
        long userCreatedTaskId = userCreatedTask.getId();
        managerTaskService.createTask(
                userCreatedTaskId, Long.parseLong(stringEmployeeId),
                taskDescription, LocalDate.now());
        return "redirect:/employee/tasks/" + stringEmployeeId;
    }

    @PostMapping("/employee/{employeeId}/task/{taskId}/delete")
    public String deleteTask(
            @PathVariable(name = "employeeId") String stringEmployeeId,
            @PathVariable(name = "taskId") String stringTaskId
    ) {
        managerTaskService.deleteTask(stringTaskId);
        return "redirect:/employee/tasks/" + stringEmployeeId;
    }
}
