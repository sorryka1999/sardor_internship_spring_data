package megafon.internship.controllers;

import megafon.internship.services.EmployeesService;
import megafon.internship.services.InternsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private InternsService internsService;

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("interlist")
    public String interlist(Model model) {
        model.addAttribute("internslist", internsService.getAllInterns());
        return "interlist";
    }

    @GetMapping("employeelist")
    public String employeelist(Model model) {
        model.addAttribute("employeelist", employeesService.getAllEmployees());
        return "employeelist";
    }

}
