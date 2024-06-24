package com.financetracker.service;

import com.financetracker.model.Expense;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseService {
    private List<Expense> expenses;

    public ExpenseService() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }

    public List<Expense> getExpensesByCategory(String category) {
        return expenses.stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public double getTotalExpenses() {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public List<Expense> getExpensesByDate(LocalDate date) {
        return expenses.stream()
                .filter(expense -> expense.getDate().equals(date))
                .collect(Collectors.toList());
    }
}
