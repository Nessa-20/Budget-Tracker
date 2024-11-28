package budgettracker.main;

import budgettracker.services.BudgetTracker;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BudgetTracker budgetTracker = new BudgetTracker();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Personal Budget Tracker ---");
            System.out.println("1. Add Category");
            System.out.println("2. Add Transaction");
            System.out.println("3. View Transactions by Category");
            System.out.println("4. View All Transactions");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter category name: ");
                    String categoryName = scanner.nextLine();
                    budgetTracker.addCategory(categoryName);
                    System.out.println("For Add Transaction For This Category Please Choose Option 2 !! ");
                    break;

                case 2:
                    System.out.print("Enter category name: ");
                    categoryName = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    budgetTracker.addTransaction(categoryName, amount, description);
                    System.out.println("Transaction Added Sucessfully!");
                    break;

                case 3:
                    System.out.print("Enter category name: ");
                    categoryName = scanner.nextLine();
                    budgetTracker.displayCategoryTransactions(categoryName);
                    break;

                case 4:
                    budgetTracker.displayAllTransactions();
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using Personal Budget Tracker!");
    }
}
