package com.soham.greendaoexample.UI.HomeScreen;

import android.app.Application;

import com.soham.greendaoexample.Entity.DaoMaster;
import com.soham.greendaoexample.Entity.DaoSession;
import com.soham.greendaoexample.Entity.Expense;
import com.soham.greendaoexample.Util.Constants;

import org.greenrobot.greendao.database.Database;

public class App extends Application {
    public DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(this, Constants.DB_NAME).getWritableDb()).newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
