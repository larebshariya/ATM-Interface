import java.util.Scanner;

class BankAcc {
    private double balance;

    public BankAcc(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit  has been successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal  has been successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

class ATM {
    private BankAcc userAccount;

    public ATM(BankAcc account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Functions:");
        System.out.println("1. Check  Bank Balance");
        System.out.println("2. Deposited Amount");
        System.out.println("3. Withdrawal Amount");
        System.out.println("4. Exit");
    }

    public void handleUserInput() {
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Current Balance: " + userAccount.getBalance());
    }

    private void deposit() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter deposit amount: ");
        double amount = in.nextDouble();
        userAccount.deposit(amount);
    }

    private void withdraw() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double amount = in.nextDouble();
        userAccount.withdraw(amount);
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAcc userAccount = new BankAcc(9800.0);

        // Create an ATM object associated with the user's bank account
        ATM atm = new ATM(userAccount);

        // Run the ATM
        atm.handleUserInput();
    }
}
