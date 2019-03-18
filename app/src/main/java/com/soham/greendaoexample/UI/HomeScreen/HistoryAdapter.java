package com.soham.greendaoexample.UI.HomeScreen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soham.greendaoexample.Entity.Expense;
import com.soham.greendaoexample.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private List<Expense> expenses;

    public HistoryAdapter(List<Expense> mExpenses) {
        this.expenses = mExpenses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.expense_history_layout, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Expense expense = expenses.get(i);
        myViewHolder.textViewId.setText(expense.getId().toString());
        myViewHolder.textViewExpense.setText(expense.getDailyExpense());
        myViewHolder.textViewCategory.setText(expense.getCategory());
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewId, textViewExpense, textViewCategory;
        public MyViewHolder(View view) {
            super(view);
            textViewId = view.findViewById(R.id.display_id);
            textViewExpense = view.findViewById(R.id.display_expense);
            textViewCategory = view.findViewById(R.id.display_category);
        }
    }
}
