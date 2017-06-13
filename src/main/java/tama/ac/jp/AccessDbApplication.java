package tama.ac.jp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tama.ac.jp.Service.UserService;

@SpringBootApplication
public class AccessDbApplication implements CommandLineRunner
{
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AccessDbApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
	}

}

