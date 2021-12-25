package com.shivam.code.commons;

import com.shivam.code.dao.*;
import com.shivam.code.server.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseDB {
    public Map<String, User> userMap;
    public Map<String, Map<String, Double>> userAccount;
    public List<Expense> expenses;

    public ExpenseDB() {
        userMap = new HashMap<>();
        userAccount = new HashMap<>();
        expenses = new ArrayList<>();
    }

    public Boolean addUser(User user) {
        if(userMap.containsKey(user.getUserId())) {
            return false;
        }

        userMap.put(user.getUserId(), user);
        userAccount.put(user.getUserId(), new HashMap<String, Double>());
        return true;
    }

    public void addExpense(Double amount, ExpenseType expenseType, User user, List<Split> splits, ExpenseMetaData expenseMetaData) {
        Expense expense = ExpenseService.addExpense(user, expenseType, amount, splits, expenseMetaData);
        expenses.add(expense);

        for(Split split : splits) {
            String userTo = split.getUser().getUserId();
            Map<String, Double> balance = userAccount.get(userTo);

            if(!balance.containsKey(userTo)) {
                balance.put(userTo, 0D);
            }

            balance.put(userTo, balance.get(userTo) + split.getAmount());

            balance = userAccount.get(userTo);

            if(!balance.containsKey(user)) {
                balance.put(user.getUserId(), 0D);
            }

            balance.put(user.getUserId(), balance.get(user.getUserId()) - split.getAmount());
        }

    }

    public void ShowBalance() {
        boolean isEmpty = true;

        for(Map.Entry<String, Map<String, Double>> balances : userAccount.entrySet()) {
            for(Map.Entry<String, Double> userBal :balances.getValue().entrySet()) {
                if(userBal.getValue() > 0D) {
                    isEmpty  = false;
                    System.out.println("User " + balances.getKey() + " Owes " + userBal.getKey() + " the sum of : " + userBal.getValue());
                }
            }

            if(isEmpty) {
                System.out.println("Nothing here!!");
            }
        }
    }
}
