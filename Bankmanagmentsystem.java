import java.util.*;

class BankAccount {
    private String ownerName;
    private int accountNumber;
    private double balance;

    BankAccount(String name, int accNo, double bal) {
        ownerName = name;
        accountNumber = accNo;
        balance = bal;
    }

    public String getOwnerName() { return ownerName; }
    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("New Balance: " + balance);
        }
    }

    void displayDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Account No: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class Bankmanagmentsystem {
    static BankAccount[] accounts = new BankAccount[10];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Bank Management System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAll();
                    break;
                case 6:
                    System.out.println("Thank you for using Bank System!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 6);
    }

    static void createAccount() {
        System.out.print("Enter owner name: ");
        String name = sc.next();
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter initial balance: ");
        double bal = sc.nextDouble();
        accounts[count] = new BankAccount(name, accNo, bal);
        count++;
        System.out.println("Account created successfully!");
    }

    static BankAccount findAccount(int accNo) {
        for(int i = 0; i < count; i++) {
            if(accounts[i].getAccountNumber() == accNo) {
                return accounts[i];
            }
        }
        return null;
    }

    static void deposit() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        BankAccount acc = findAccount(accNo);
        if(acc == null) {
            System.out.println("Account not found!");
        } else {
            System.out.print("Enter deposit amount: ");
            double amount = sc.nextDouble();
            acc.deposit(amount);
        }
    }

    static void withdraw() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        BankAccount acc = findAccount(accNo);
        if(acc == null) {
            System.out.println("Account not found!");
        } else {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
        }
    }

    static void checkBalance() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        BankAccount acc = findAccount(accNo);
        if(acc == null) {
            System.out.println("Account not found!");
        } else {
            System.out.println("Balance: " + acc.getBalance());
        }
    }

    static void displayAll() {
        if(count == 0) {
            System.out.println("No accounts found!");
        } else {
            System.out.println("=== All Accounts ===");
            for(int i = 0; i < count; i++) {
                accounts[i].displayDetails();
                System.out.println("---");
            }
        }
    }
}