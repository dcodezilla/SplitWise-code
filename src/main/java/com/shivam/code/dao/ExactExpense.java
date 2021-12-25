package com.shivam.code.dao;

import java.util.List;

public class ExactExpense extends Expense {

    public ExactExpense( Double amount, User user, List<Split> splitList, ExpenseMetaData expenseMetaData) {
        super(amount, user, splitList, expenseMetaData);
    }

    @Override
    public boolean correctTypeOfExpense() {
        for(Split split: splitList) {
            if(!(split instanceof ExactSplit)) {
                return false;
            }
        }

        Double totalAmount = getAmount();
        Double initAmount = 0D;

        for (Split split: splitList) {
            initAmount += split.getAmount();
        }

        if(initAmount != totalAmount) {
            return false;
        }
        return true;
    }
}
