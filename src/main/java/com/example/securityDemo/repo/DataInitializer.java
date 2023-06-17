package com.example.securityDemo.repo;

import com.example.securityDemo.model.Role;
import com.example.securityDemo.model.User;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LogManager.getLogger("DataInitializer");

    @Override
    public void run(String... args) throws Exception {
        // muserRepository.deleteAll();
         if (userRepository.count() == 0) {
            User admin = new User();
            admin.setUsername("a");
            admin.setPassword(passwordEncoder.encode("a"));

            admin.setRole(Role.ADMIN);
            userRepository.save(admin);
            logger.info(admin);
//-------------
            User user = new User();
            user.setUsername("u");
            user.setPassword(passwordEncoder.encode("u"));

            user.setRole(Role.USER);
            userRepository.save(user);
            logger.info(user);

        }else {logger.info("!!! We  have already users !!!!!");}
    }
}
