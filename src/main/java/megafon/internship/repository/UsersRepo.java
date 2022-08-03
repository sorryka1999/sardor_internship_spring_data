package megafon.internship.repository;

import megafon.internship.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {

    public Users findByEmail(String email);
}
