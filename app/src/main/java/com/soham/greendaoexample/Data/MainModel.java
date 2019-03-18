package com.soham.greendaoexample.Data;

import android.content.SharedPreferences;
import android.util.Log;

import com.soham.greendaoexample.Entity.Expense;
import com.soham.greendaoexample.Entity.ExpenseDao;
import com.soham.greendaoexample.Util.Constants;
import com.soham.greendaoexample.Util.Utils;

import java.util.List;

public class MainModel {

    ExpenseDao expenseDao;

    public void saveData(String amount, String category, ExpenseDao mExpenseDao){
        mExpenseDao.insert(new Expense(null, amount, category));
        expenseDao = mExpenseDao;
    }

    public String totalDailyExpense(String currentExpense, SharedPreferences sharedPreferences){

        //calculate total daily expense
        String dailyExpense = sharedPreferences.getString(Constants.DAILY_EXPENSE, "00");
        dailyExpense = Utils.calculateTotalDailyExpense(dailyExpense, currentExpense);

        //update shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.DAILY_EXPENSE, dailyExpense);
        editor.commit();

        //return updated daily expense
        return dailyExpense;
    }

    public List<Expense> getAllData() {
        List<Expense> expenses = expenseDao.queryBuilder().orderDesc(ExpenseDao.Properties.Id).build().list();
        return expenses;
    }
}
