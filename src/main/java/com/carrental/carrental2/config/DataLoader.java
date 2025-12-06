package com.carrental.carrental2.config;

import com.carrental.carrental2.model.AppUser;
import com.carrental.carrental2.model.Role;
import com.carrental.carrental2.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner seedAdmin(AppUserRepository repo, PasswordEncoder encoder) {
        return args -> {

            if (repo.count() == 0) {
                AppUser superAdmin = new AppUser();
                superAdmin.setUsername("superadmin");
                superAdmin.setPassword(encoder.encode("Ardi123"));
                superAdmin.setRoles(Set.of(Role.SUPERADMIN));

                repo.save(superAdmin);

                System.out.println("Seeded default superadmin : superadmin/Ardi123");
            }
        };
    }
}
