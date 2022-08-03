package megafon.internship.services;

import megafon.internship.entity.Employees;
import megafon.internship.repository.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepo employeesRepo;

    public List<Employees> getAllEmployees() {
        return employeesRepo.findAll();
    }

    public void addEmployee(String name, String surname, String position) {
        Employees employees = new Employees(name, surname, position);
        employeesRepo.save(employees);
    }

    public Employees getEmployeeById(long employeeId) {
        Optional<Employees> employees = employeesRepo.findById(employeeId);
        return employees.get();
    }

    public void deleteEmployee(long employeeId) {
        employeesRepo.delete(getEmployeeById(employeeId));
    }

    public void updateEmployee(long employeeId, String name, String surname, String position) {
        Employees employee = getEmployeeById(employeeId);
        employee.setName(name);
        employee.setSurname(surname);
        employee.setPosition(position);
        employeesRepo.save(employee);
    }
}
