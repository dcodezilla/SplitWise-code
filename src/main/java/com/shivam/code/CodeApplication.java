package com.shivam.code;

import com.shivam.code.commons.ExpenseDB;
import com.shivam.code.dao.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@SpringBootApplication
public class CodeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		System.out.println("Hello");
		SpringApplication.run(CodeApplication.class, args);

		ExpenseDB expenseDB = new ExpenseDB();

		expenseDB.addUser(new User("u1", "user1", "us=@a.b", "abc"));
		expenseDB.addUser(new User("u2", "user2", "us=@a.b", "abc"));
		expenseDB.addUser(new User("u3", "user3", "us=@a.b", "abc"));
		expenseDB.addUser(new User("u4", "user4", "us=@a.b", "abc"));


		User user1  = new User("u1", "user1", "us=@a.b", "abc");
		User user2 = new User("u2", "user2", "us=@a.b", "abc");


		Split split1 = new ExactSplit(user1, 100D);
		Split split2 = new ExactSplit(user2, 100D);

		List<Split> splits = new ArrayList<>();
		splits.add(split1);
		splits.add(split2);

		ExpenseMetaData expenseMetaData = new ExpenseMetaData("Test", "Description goes here");
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
