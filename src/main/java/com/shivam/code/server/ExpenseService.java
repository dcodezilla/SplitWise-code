package com.shivam.code.server;

import com.shivam.code.dao.*;

import java.util.List;

public class ExpenseService {

    public static Expense addExpense(User user, ExpenseType expenseType, Double amount, List<Split> splits, ExpenseMetaData expenseMetaData) {
        if(expenseType.equals(ExpenseType.EXACT)) {
            return new ExactExpense(amount, user, splits, expenseMetaData);
        }

        //other case
        return new ExactExpense(amount, user, splits, expenseMetaData);
    }


}
