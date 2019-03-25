package com.soham.greendaoexample.UI.HomeScreen;

import android.content.SharedPreferences;

import com.soham.greendaoexample.Data.MainModel;
import com.soham.greendaoexample.Entity.Expense;
import com.soham.greendaoexample.Entity.ExpenseDao;

import java.util.List;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View view;
    private MainModel model;

    private SharedPreferences sharedPreferences;
    private ExpenseDao expenseDao;

    MainPresenter(MainContract.View view, ExpenseDao expenseDao, SharedPreferences sharedPreferences){
        this.model = new MainModel();
        this.view = view;
        this.expenseDao = expenseDao;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void onSaveButtonClicked(String amount, String category) {
        model.saveData(amount, category, expenseDao);
        String dailyExpense = model.totalDailyExpense(amount, sharedPreferences);
        onDataSaved(dailyExpense);
    }

    @Override
    public void onDataSaved(String dailyExpense) {
        List<Expense>  expenses = model.getAllData();
        view.displayDailyExpense(dailyExpense, expenses);
    }
}
