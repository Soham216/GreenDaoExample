package com.soham.greendaoexample;

import com.soham.greendaoexample.Data.MainModel;
import com.soham.greendaoexample.Entity.Expense;
import com.soham.greendaoexample.Entity.ExpenseDao;
import com.soham.greendaoexample.Util.Utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExampleMockTest {

    @Mock
    MainModel mainModel;
    @Mock
    ExpenseDao expenseDao;
    @Mock
    List<Expense> mockList;
    @Mock
    Utils mockUtil;

    public static final String DAILY_EXPENSE = "10000";
    public static final String AMOUNT = "2022";

    @Test
    public void testDailyExpenseCalculator() {
        String result = mockUtil.calculateTotalDailyExpense(DAILY_EXPENSE, AMOUNT);
        assertThat(result, is("12022"));
    }

    @Test
    public void testToSaveDataToDatabase(){
        mainModel.saveData("1001", "Home", expenseDao);
    }

    @Test
    public void testToGetAllDataFromDatabase(){
        mainModel.saveData("10265", "home", expenseDao);
        when(mainModel.getAllData())
                .thenReturn(mockList)
                .thenThrow(NullPointerException.class);
        mainModel.getAllData();
    }
}
