package budgettracker.models;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Transaction> transactions;

    public Category(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
