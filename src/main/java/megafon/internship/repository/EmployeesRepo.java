package megafon.internship.repository;

import megafon.internship.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepo extends JpaRepository<Employees, Long> {
}
