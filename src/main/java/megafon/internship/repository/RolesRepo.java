package megafon.internship.repository;

import megafon.internship.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepo extends JpaRepository<Roles, Long> {

    public Roles findByRole(String role);
}
