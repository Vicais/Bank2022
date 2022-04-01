import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.Scanner;



public class Account {
    int balance;
    int previousTransaction;
    String custumerName;
    String getCustumerID;

    //class constructor
    Account(String cname, String cid) {

        custumerName = cname;
        getCustumerID = cid;

    }
    //function for depositing money

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    // func for withdrawing
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTranssaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    //func to calculate the interest of invest the money
    void calculateInterest(int years) {
        double interestRate = .015;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + "years, your balance will be: " + newBalance);
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + custumerName + "!");
        System.out.println("Your ID is: " + getCustumerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdraw");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase((option1));
            System.out.println();
            switch (option) {
                case 'A':
                    System.out.println("==============================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("==============================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("=============================");
                    getPreviousTranssaction();
                    System.out.println("=============================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter for how many years you want to keep the money");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("===============================");
                    break;
                default:
                    System.out.println("Error: invalid option.");
                    break;

            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}