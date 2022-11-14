package jay.springboot.student_management_system_API;

import jay.springboot.student_management_system_API.model.AppUser;
import jay.springboot.student_management_system_API.model.Role;
import jay.springboot.student_management_system_API.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class StudentManagementSystemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApiApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AppUserService appUserService){
		return args -> {
			appUserService.insertNewRole(new Role(null, "ROLE_USER"));
			appUserService.insertNewRole(new Role(null, "ROLE_MANAGER"));
			appUserService.insertNewRole(new Role(null, "ROLE_ADMIN"));
			appUserService.insertNewRole(new Role(null, "ROLE_SUPER_ADMIN"));

			appUserService.insertNewUser(new AppUser(null, "John Travolta", "john", "1234",new ArrayList<>()));
			appUserService.insertNewUser(new AppUser(null, "Will Smith", "will", "1234",new ArrayList<>()));
			appUserService.insertNewUser(new AppUser(null, "Jim Cary", "jim", "1234",new ArrayList<>()));
			appUserService.insertNewUser(new AppUser(null, "Tom Crus", "tom", "1234",new ArrayList<>()));

			appUserService.addRoleToUser("john", "ROLE_USER");
			appUserService.addRoleToUser("john", "ROLE_MANAGER");
			appUserService.addRoleToUser("will", "ROLE_MANAGER");
			appUserService.addRoleToUser("jim", "ROLE_ADMIN");
			appUserService.addRoleToUser("tom", "ROLE_USER");
			appUserService.addRoleToUser("tom", "ROLE_ADMIN");
			appUserService.addRoleToUser("tom", "ROLE_SUPER_ADMIN");
		};
	}

}
