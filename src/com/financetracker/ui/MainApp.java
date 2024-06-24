package com.financetracker.ui;

import com.financetracker.model.Expense;
import com.financetracker.service.ExpenseService;

import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {
    private static ExpenseService expenseService = new ExpenseService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewAllExpenses();
                    break;
                case 3:
                    viewExpensesByCategory();
                    break;
                case 4:
                    viewTotalExpenses();
                    break;
                case 5:
                    viewExpensesByDate();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. Add Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. View Expenses By Category");
        System.out.println("4. View Total Expenses");
        System.out.println("5. View Expenses By Date");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addExpense() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Expense expense = new Expense(category, amount, date, description);
        expenseService.addExpense(expense);
        System.out.println("Expense added successfully.");
    }

    private static void viewAllExpenses() {
        System.out.println("All Expenses:");
        expenseService.getAllExpenses().forEach(System.out::println);
    }

    private static void viewExpensesByCategory() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.println("Expenses in category " + category + ":");
        expenseService.getExpensesByCategory(category).forEach(System.out::println);
    }

    private static void viewTotalExpenses() {
        double total = expenseService.getTotalExpenses();
        System.out.println("Total Expenses: " + total);
    }

    private static void viewExpensesByDate() {
        System.out.print("Enter date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.println("Expenses on " + date + ":");
        expenseService.getExpensesByDate(date).forEach(System.out::println);
    }
}
