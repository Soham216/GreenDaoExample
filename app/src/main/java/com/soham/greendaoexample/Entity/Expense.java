package com.soham.greendaoexample.Entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "expense")
public class Expense {

    @Id(autoincrement = true)
    public Long id;
    @Property(nameInDb = "dailyexpense")
    public String dailyExpense;
    @Property(nameInDb = "category")
    public String category;
    @Generated(hash = 23815207)
    public Expense(Long id, String dailyExpense, String category) {
        this.id = id;
        this.dailyExpense = dailyExpense;
        this.category = category;
    }
    @Generated(hash = 2061519627)
    public Expense() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDailyExpense() {
        return this.dailyExpense;
    }
    public void setDailyExpense(String dailyExpense) {
        this.dailyExpense = dailyExpense;
    }
    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
