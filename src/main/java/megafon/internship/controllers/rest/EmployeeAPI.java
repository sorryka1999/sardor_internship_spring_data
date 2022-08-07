package megafon.internship.controllers.rest;

import megafon.internship.dao.EmployeeDAO;
import megafon.internship.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeAPI {

    @Autowired
    private EmployeesService employeesService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<EmployeeDAO> employees() {
        return employeesService.getAllEmployeesDAO();
    }


    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> deleteEmployee(@PathVariable String employeeId) {
        employeesService.deleteEmployee(Long.parseLong(employeeId));
        Map<String, String> responseMessage = new HashMap<>();
        responseMessage.put("message", "user with id:" + employeeId + " is deleted");
        return responseMessage;
    }

}
