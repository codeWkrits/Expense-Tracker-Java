import java.util.*;

class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }
}

public class Main {
    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- EXPENSE TRACKER ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Spending");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addExpense(); break;
                case 2: viewExpenses(); break;
                case 3: totalSpending(); break;
                case 4: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    static void addExpense() {
        System.out.print("Enter category: ");
        String category = sc.nextLine();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        expenses.add(new Expense(category, amount));
        System.out.println("Expense added!");
    }

    static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        for (int i = 0; i < expenses.size(); i++) {
            Expense e = expenses.get(i);
            System.out.println((i + 1) + ". " + e.category + " - ₹" + e.amount);
        }
    }

    static void totalSpending() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        System.out.println("Total Spending: ₹" + total);
    }
}
