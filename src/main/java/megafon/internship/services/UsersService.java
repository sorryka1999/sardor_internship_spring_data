package megafon.internship.services;

import megafon.internship.entity.Roles;
import megafon.internship.entity.Users;
import megafon.internship.repository.RolesRepo;
import megafon.internship.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private RolesRepo rolesRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Users> getAllUsers() {
        return usersRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = usersRepo.findByEmail(email);
        if (users == null) {
            throw new UsernameNotFoundException(email);
        }
        return users;
    }

    public boolean doesEmailExist(String email) {
        return usersRepo.findByEmail(email) != null;
    }

    public void addUser(
            String name, String surname, String age,
            String email, String password, String role) {
        Roles roles = rolesRepo.findByRole(role);
        Users users = new Users(
                name, surname, Integer.parseInt(age),
                email, passwordEncoder.encode(password), roles, true);
        usersRepo.save(users);
    }

    public Users getUserById(long userId) {
        Optional<Users> users = usersRepo.findById(userId);
        return users.get();
    }

    public void changeStatus(Long userId) {
        Users users = getUserById(userId);
        users.setActive(!users.getActive());
        usersRepo.save(users);
    }

    public void deleteUser(long userId) {
        usersRepo.deleteById(userId);
    }

    public void updateUser(
            long id, String name, String surname, String age,
            String email, String password, String role) {
        Users users = getUserById(id);
        users.setName(name);
        users.setSurname(surname);
        users.setAge(Integer.parseInt(age));
        users.setEmail(email);
        users.setPassword(passwordEncoder.encode(password));
        Roles roles = rolesRepo.findByRole(role);
        users.setRole(roles);
        usersRepo.save(users);
    }
}
