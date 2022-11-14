package jay.springboot.student_management_system_API.service;

import jay.springboot.student_management_system_API.model.AppUser;
import jay.springboot.student_management_system_API.model.Role;
import jay.springboot.student_management_system_API.repository.AppUserRepository;
import jay.springboot.student_management_system_API.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService{

    private final AppUserRepository appUserRepository;

    private final RoleRepository roleRepository;

    @Override
    public AppUser insertNewUser(AppUser appUser) {
        log.info("Saving new user {} to the database", appUser.getName());
        return appUserRepository.save(appUser);
    }

    @Override
    public Role insertNewRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        AppUser appUser = appUserRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        log.info("Fetching user {}", username);
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getAllUsers() {
        log.info("Fetching all user");
        return appUserRepository.findAll();
    }
}
