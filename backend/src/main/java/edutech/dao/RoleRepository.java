package edutech.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import edutech.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByName(String name);
}