package com.soham.greendaoexample.UI.HomeScreen;

import com.soham.greendaoexample.Entity.Expense;

import java.util.List;

public interface MainContract {

    interface View {
        void onSaveButtonClick();
        void displayDailyExpense(String totalAmount, List<Expense> expenses);
    }

    interface Presenter {
        void onSaveButtonClicked(String amount, String category);
        void onDataSaved(String amount);
    }
}
