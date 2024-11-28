package budgettracker.services;

import budgettracker.models.Category;
import budgettracker.models.Transaction;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BudgetTracker {
    private Map<String, Category> categories;

    public BudgetTracker() {
        this.categories = new HashMap<>();
    }

    public void addCategory(String categoryName) {
        categories.putIfAbsent(categoryName, new Category(categoryName));
    }

    public void addTransaction(String categoryName, double amount, String description) {
        Category category = categories.get(categoryName);
        if (category != null) {
            category.addTransaction(new Transaction(amount, LocalDate.now(), description));
        } else {
            System.out.println("Category does not exist.");
        }
    }

    public void displayAllTransactions() {
        for (Category category : categories.values()) {
            System.out.println("Category: " + category.getName());
            for (Transaction transaction : category.getTransactions()) {
                System.out.println("Date: " + transaction.getDate() +
                        " | Amount: " + transaction.getAmount() +
                        " | Description: " + transaction.getDescription());
            }
        }
    }

    public void displayCategoryTransactions(String categoryName) {
        Category category = categories.get(categoryName);
        if (category != null) {
            System.out.println("Transactions for " + categoryName + ":");
            for (Transaction transaction : category.getTransactions()) {
                System.out.println("Date: " + transaction.getDate() +
                        " | Amount: " + transaction.getAmount() +
                        " | Description: " + transaction.getDescription());
            }
        } else {
            System.out.println("Category does not exist.");
        }
    }
}
