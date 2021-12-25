package com.shivam.code.dao;

import java.util.List;

public abstract class Expense {
    String expenseId;
    Double amount;
    User user;
    List<Split> splitList;
    ExpenseMetaData expenseMetaData;


    public Expense( Double amount, User user, List<Split> splitList, ExpenseMetaData expenseMetaData) {
        this.amount = amount;
        this.user = user;
        this.splitList = splitList;
        this.expenseMetaData = expenseMetaData;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public void setSplitList(List<Split> splitList) {
        this.splitList = splitList;
    }

    public ExpenseMetaData getExpenseMetaData() {
        return expenseMetaData;
    }

    public void setExpenseMetaData(ExpenseMetaData expenseMetaData) {
        this.expenseMetaData = expenseMetaData;
    }

    public abstract boolean correctTypeOfExpense();
}
