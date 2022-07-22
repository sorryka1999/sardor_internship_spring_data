package megafon.internship.repository;

import megafon.internship.entity.Interns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternsRepo extends JpaRepository<Interns, Long> {
}
