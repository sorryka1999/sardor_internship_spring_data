package megafon.internship.controllers;

import megafon.internship.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/employee")
    public String employee(Model model) {
        model.addAttribute("employees", employeesService.getAllEmployees());
        return "employee";
    }

    @PostMapping("/employee/add")
    public String addEmployee(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String position
    ) {
        employeesService.addEmployee(name, surname, position);
        return "redirect:/employee";
    }

    @GetMapping("/employee/edit/{employeeId}")
    public String userEmployee(
            @PathVariable String employeeId,
            Model model
    ) {
        model.addAttribute(
                "employee",
                employeesService.getEmployeeById(Long.parseLong(employeeId)));
        return "employeeEdit";
    }

    @PostMapping("/employee/edit/{employeeId}/delete")
    public String deleteEmployee(
            @PathVariable String employeeId
    ) {
        employeesService.deleteEmployee(Long.parseLong(employeeId));
        return "redirect:/employee";
    }

    @PostMapping("/employee/edit/{employeeId}/update")
    public String updateEmployee(
            @PathVariable String employeeId,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String position
    ) {
        employeesService.updateEmployee(Long.parseLong(employeeId), name, surname, position);
        return "redirect:/employee";
    }

}
