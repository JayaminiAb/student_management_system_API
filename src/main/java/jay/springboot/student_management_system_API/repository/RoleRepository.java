package jay.springboot.student_management_system_API.repository;

import jay.springboot.student_management_system_API.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
