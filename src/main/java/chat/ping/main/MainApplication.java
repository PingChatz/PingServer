package chat.ping.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Starting point of the application
@SpringBootApplication
public class MainApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(MainApplication.class, args);
	}
}
