package Projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: " + amount);
    }

    public void withdrawal(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: " + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if (amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add("Transfer to " + recipient.getAccountHolder() + ": - " + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void printTransactionHistory() {
        System.out.println(" Transaction History for Account " + accountNumber);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
}

public class OnlineBankingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Account Number :");
        String accountNUm1 = input.next();
        System.out.print("Enter Account User Name :");
        String name1 = input.next();
        // create account
        BankAccount account1 = new BankAccount(name1, accountNUm1);

        System.out.print("Enter Account Number :");
        String accountNUm2 = input.next();
        System.out.print("Enter Account User Name :");
        String name2 = input.next();
        // ctrate another account
        BankAccount account2 = new BankAccount(name2, accountNUm2);

        // perform operations
        System.out.println("Enter Deposit amount: ");
        double amount=input.nextDouble();
        account1.deposit(amount);

        System.out.println("Enter Withdrawal amount: ");
        amount =input.nextDouble();
        account1.withdrawal(amount);

        System.out.println("Enter Transfer amount: ");
        amount=input.nextDouble();
        account1.transfer(account2, 110);

        // account2.deposit(1999);
        // account2.withdrawal(450);

        // view transactions history
        account1.printTransactionHistory();
        account2.printTransactionHistory();

        input.close();
    }
}
