package megafon.internship.services;

import megafon.internship.entity.Employees;
import megafon.internship.repository.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepo employeesRepo;

    public List<Employees> getAllEmployees() {
        return employeesRepo.findAll();
    }

}
