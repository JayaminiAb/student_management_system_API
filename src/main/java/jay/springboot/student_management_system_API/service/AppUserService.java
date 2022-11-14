package jay.springboot.student_management_system_API.service;

import jay.springboot.student_management_system_API.model.AppUser;
import jay.springboot.student_management_system_API.model.Role;

import java.util.List;

public interface AppUserService {
    AppUser insertNewUser(AppUser appUser);

    Role insertNewRole(Role role);

    void addRoleToUser(String username, String roleName);

    AppUser getUserByUsername(String username);

    List<AppUser> getAllUsers();
}
