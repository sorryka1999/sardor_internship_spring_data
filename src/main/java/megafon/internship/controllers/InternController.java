package megafon.internship.controllers;

import megafon.internship.services.InternsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InternController {

    @Autowired
    private InternsService internsService;

    @GetMapping("/intern")
    public String intern(Model model) {
        model.addAttribute("interns", internsService.getAllInterns());
        return "intern";
    }

    @PostMapping("/intern/add")
    public String addIntern(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String age,
            @RequestParam String hobby
    ) {
        internsService.addIntern(name, surname, Integer.parseInt(age), hobby);
        return "redirect:/intern";
    }

    @GetMapping("/intern/edit/{internId}")
    public String internEdit(
            @PathVariable String internId,
            Model model
    ) {
        model.addAttribute("intern", internsService.getInternById(Long.parseLong(internId)));
        return "internEdit";
    }

    @PostMapping("/intern/edit/{internId}/delete")
    public String deleteIntern(
            @PathVariable String internId
    ) {
        internsService.deleteIntern(Long.parseLong(internId));
        return "redirect:/intern";
    }

    @PostMapping("/intern/edit/{internId}/update")
    public String updateIntern(
            @PathVariable String internId,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String hobby
    ) {
        internsService.updateIntern(Long.parseLong(internId), name, surname, hobby);
        return "redirect:/intern";
    }

}
