package com.trade.authservice;

import com.trade.authservice.Register.RegisterRequest;
import com.trade.authservice.demo.AdminService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

import static com.trade.authservice.User.Role.SUPER_ADMIN;
import static com.trade.authservice.utils.Status.ACTIVE;

@CrossOrigin
@SpringBootApplication
//@EnableDiscoveryClient
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			AdminService adminService
	) {
		return args -> {
			var superAdmin = RegisterRequest.builder()
					.email("ckoech141@gmail.com")
					.password("Tan@2020")
					.fullName("Collins Koech")
					.role(SUPER_ADMIN)
					.status(ACTIVE)
					.build();

			var adminResponse = adminService.addNewUser(superAdmin);
			if (adminResponse.getStatusCode() == HttpStatus.CREATED.value()) {
				System.out.println("Super Admin token: " + adminResponse.getEntity().getAccessToken());
			} else {
				System.out.println(" sorry !! super admin already registered: " + adminResponse.getMessage());
			}

		};

	}

}

