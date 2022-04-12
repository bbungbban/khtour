package ksmart42.khtour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class KhtourApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhtourApplication.class, args);
	}

}
