package com.soham.greendaoexample.UI.HomeScreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.sip.SipSession;

import com.soham.greendaoexample.Entity.DaoSession;
import com.soham.greendaoexample.Entity.Expense;
import com.soham.greendaoexample.Entity.ExpenseDao;

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
