package com.soham.greendaoexample.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.soham.greendaoexample.UI.HomeScreen.MainActivity;
import com.soham.greendaoexample.UI.HomeScreen.MainContract;

public class Utils {

    public static void showToast(String msg, Context context){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static String calculateTotalDailyExpense(String dailyExpense, String currentExpense){
        int updatedDailyExpense = Integer.parseInt(dailyExpense) + Integer.parseInt(currentExpense);
        dailyExpense = "" + updatedDailyExpense;
        return dailyExpense;
    }

}
