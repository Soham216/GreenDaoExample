package com.soham.greendaoexample.UI.HomeScreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.soham.greendaoexample.Entity.Expense;
import com.soham.greendaoexample.Entity.ExpenseDao;
import com.soham.greendaoexample.R;
import com.soham.greendaoexample.Util.Constants;
import com.soham.greendaoexample.Util.Utils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private TextView textDailyExpense;
    private EditText textEnterAmount;
    private Button buttonSave;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    private MainContract.Presenter presenter;
    private HistoryAdapter historyAdapter;
    private RecyclerView recyclerView;

    ExpenseDao expenseDao;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expenseDao = ((App)getApplication()).getDaoSession().getExpenseDao();
        sharedPreferences = getSharedPreferences(Constants.MY_PREFERENCES, Context.MODE_PRIVATE);

        presenter = new MainPresenter(this, expenseDao, sharedPreferences);

        textDailyExpense = findViewById(R.id.text_expense);
        textEnterAmount = findViewById(R.id.text_enter_amount);
        radioGroup = findViewById(R.id.radio_group_categories);
        buttonSave = findViewById(R.id.button_save);

        //on save click
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveButtonClick();
            }
        });
    }

    @Override
    public void onSaveButtonClick() {
        int categoryId = radioGroup.getCheckedRadioButtonId();
        radioButton = radioGroup.findViewById(categoryId);

        if(categoryId > -1){
            presenter.onSaveButtonClicked(textEnterAmount.getText().toString(), radioButton.getText().toString());
        }else {
            Utils.showToast("Select Category", this);
        }
    }

    @Override
    public void displayDailyExpense(String totalAmount, List<Expense> expenses) {
        Utils.showToast("Saved Successfully", this);

        recyclerView = findViewById(R.id.recycler_view);
        historyAdapter = new HistoryAdapter(expenses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(historyAdapter);

        textDailyExpense.setText(totalAmount);
    }

}
