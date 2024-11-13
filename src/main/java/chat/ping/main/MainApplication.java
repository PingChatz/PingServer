package chat.ping.main;

import chat.ping.main.domain.models.User;
import chat.ping.main.domain.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// Starting point of the application
@SpringBootApplication
public class MainApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(MainApplication.class, args);
	}

	// Code to test my User repository
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository)
	{
		return args -> {
			User user = new User("rahbaral", "alirahabr2005@gmail.com", "1230");
			userRepository.save(user);
		};
	}
}
