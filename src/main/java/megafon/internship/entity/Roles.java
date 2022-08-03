package megafon.internship.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Roles implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "roles_id_seq")
    private Long id;
    private String role;
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Users> users;

    public Roles() {
    }

    public Roles(String role, String name) {
        this.role = role;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}
