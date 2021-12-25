package com.shivam.code;

import com.shivam.code.commons.ExpenseDB;
import com.shivam.code.dao.*;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CodeApplicationTests {

	CodeApplication codeApplication;
	ExpenseDB expenseDB = new ExpenseDB();

	User user1, user2;
	Split split1, split2;
	List<Split> splits;
	ExpenseMetaData expenseMetaData;


	@BeforeEach
	public void init() {
		//codeApplication = new CodeApplication();

		//interview@barraiser.com


		expenseDB.addUser(new User("u1", "user1", "us=@a.b", "abc"));
		expenseDB.addUser(new User("u2", "user2", "us=@a.b", "abc"));
		expenseDB.addUser(new User("u3", "user3", "us=@a.b", "abc"));
		expenseDB.addUser(new User("u4", "user4", "us=@a.b", "abc"));

		 user1  = new User("u1", "user1", "us=@a.b", "abc");
		 user2 = new User("u2", "user2", "us=@a.b", "abc");


		 split1 = new ExactSplit(user1, 100D);
		 split2 = new ExactSplit(user2, 100D);

		 splits = new ArrayList<>();
		splits.add(split1);
		splits.add(split2);

		 expenseMetaData = new ExpenseMetaData("Test", "Description goes here");





	}

	@Test
	void addExpenseTest() {
		expenseDB.addExpense(10D, ExpenseType.EXACT, user1, splits,expenseMetaData);

		Assertions.assertTrue(!expenseDB.userAccount.isEmpty());
	}

	@Test
	void printBalances() {
		expenseDB.addExpense(100D, ExpenseType.EXACT, user1, splits,expenseMetaData);

		expenseDB.ShowBalance();
	}



}
