package jay.springboot.student_management_system_API.repository;

import jay.springboot.student_management_system_API.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
