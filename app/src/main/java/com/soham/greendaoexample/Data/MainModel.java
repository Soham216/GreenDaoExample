package com.soham.greendaoexample.Data;

import android.content.SharedPreferences;

import com.soham.greendaoexample.Entity.Expense;
import com.soham.greendaoexample.Entity.ExpenseDao;
import com.soham.greendaoexample.Util.Constants;
import com.soham.greendaoexample.Util.Utils;

import java.util.List;


public class MainModel {

    private static final String DEFAULT_DAILY_EXPENSE = "00";
    private ExpenseDao expenseDao;

    //insert data into database.
    public void saveData(String amount, String category, ExpenseDao mExpenseDao){
        try {
            mExpenseDao.insert(new Expense(null, amount, category));
        }catch (Exception e){
            e.printStackTrace();
        }

        expenseDao = mExpenseDao;
    }

    //update the daily total expense.
    public String totalDailyExpense(String currentExpense, SharedPreferences sharedPreferences){
        String dailyExpense = "";

        try {
            dailyExpense = sharedPreferences.getString(Constants.DAILY_EXPENSE, DEFAULT_DAILY_EXPENSE);
            dailyExpense = Utils.calculateTotalDailyExpense(dailyExpense, currentExpense);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Constants.DAILY_EXPENSE, dailyExpense);
            editor.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        return dailyExpense;
    }

    //fetch all data in the database.
    public List<Expense> getAllData() {
        List<Expense> expenses = null;

        try{
            expenses = expenseDao.queryBuilder().orderDesc(ExpenseDao.Properties.Id).build().list();
        }catch (Exception e){
            e.printStackTrace();
        }

        return expenses;
    }
}