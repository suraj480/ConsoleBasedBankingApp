import java.util.Scanner;

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid) {
        this.customerName = cname;
        this.customerId = cid;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withDraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited :" + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn :" + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction has happened");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("welcome " + customerName);
        System.out.println("Your ID is" + customerId);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("==================================");
            System.out.println("Enter the option");
            System.out.println("======================================");
            // taking first charactor of user
            option = sc.next().charAt(0);
            Character.toUpperCase(option);
            switch (option) {

                case 'A':
                    System.out.println("==================================");
                    System.out.println("Balace is: " + balance);
                    System.out.println("==================================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("==================================");
                    System.out.println("Enter the amount to deposit");
                    System.out.println("==================================");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("==================================");
                    System.out.println("Enter the amount to withdraw");
                    System.out.println("==================================");
                    int amountWithdraw = sc.nextInt();
                    withDraw(amountWithdraw);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("==================================");
                    getPreviousTransaction();
                    System.out.println("==================================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("==================================");
                    break;
                default:
                    System.out.println("Invalid option please try again");
                    break;
            }

        } while (option != 'E');

    }

}

public class BankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount bank1 = new BankAccount("suraj", "01");
        bank1.showMenu();
    }
}