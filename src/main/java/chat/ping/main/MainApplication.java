package chat.ping.main;

import chat.ping.main.domain.models.User;
import chat.ping.main.domain.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
//import chat.ping.main.config.SecurityConfig.passwordEncoder;

// Starting point of the application
@SpringBootApplication
public class MainApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(MainApplication.class, args);
	}
}
