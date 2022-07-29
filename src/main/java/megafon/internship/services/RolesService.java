package megafon.internship.services;

import megafon.internship.entity.Roles;
import megafon.internship.repository.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {

    @Autowired
    private RolesRepo rolesRepo;

    public List<Roles> getAllRoles() {
        return rolesRepo.findAll();
    }
}
