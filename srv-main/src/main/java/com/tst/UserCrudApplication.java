package com.tst;

import com.tst.user.service.UserInitializer;
import com.tst.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserCrudApplication implements CommandLineRunner {
	@Autowired private UserInitializer userInitializer;
	@Autowired private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(UserCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (userService.count() == 0) {
			userInitializer.start();
		}
	}
}
