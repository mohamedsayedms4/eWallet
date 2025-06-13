package service;

import model.Account;
import model.EWallet;

import java.util.Scanner;

/**
 * This class implements the ApplicationService interface.
 * It handles the main application logic such as signing up, logging in,
 * and performing wallet operations like deposit, withdraw, and transfer.
 */
public class ApplicationServiceImp implements ApplicationService {
    // Scanner for user input
    Scanner sc = new Scanner(System.in);

    // Account service instance to handle account operations
    AccountService accountService = new AccountServiceImp();

    /**
     * Starts the main application loop, allowing the user to sign up or sign in.
     */
    @Override
    public void start() {
        System.out.println("Welcome Sir");

        int testCases = 3; // Maximum number of invalid attempts allowed
        while (testCases > 0) {
            System.out.println("please choose one of the following options:");
            System.out.println("1. sign up     2. sign in");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    signUp();
                    signIn(); // Automatically sign in after sign up
                    break;
                case 2:
                    signIn();
                    break;
                default:
                    System.out.println("Invalid choice");
                    testCases--; // Decrease testCases on invalid input
            }

            if (testCases == 0) {
                System.out.println("please try again another time");
            }
        }
    }

    /**
     * Handles the user registration process.
     */
    private void signUp() {
        System.out.println("please Enter your name");
        String userName = sc.next();

        System.out.println("please Enter your password");
        String password = sc.next();

        System.out.println("please Enter your Full Number");
        String fullNumber = sc.next();

        System.out.println("please enter your Age");
        int age = sc.nextInt();

        Account account = new Account(userName, password, fullNumber, age);
        boolean isCreatedAccount = accountService.createAccount(account);

        if (isCreatedAccount) {
            System.out.println("Account created");
        } else {
            System.out.println("Account not created");
        }
    }

    /**
     * Handles the user login process.
     */
    private void signIn() {
        System.out.println("please Enter your name");
        String userName = sc.next();

        System.out.println("please Enter your password");
        String password = sc.next();

        Account account = new Account(userName, password);
        boolean isLoginedAccount = accountService.login(account);

        if (isLoginedAccount) {
            System.out.println("Account logged in");

            // Get the full account object (with balance and other info)
            Account fullAccount = accountService.getAccountByUsername(userName);
            if (fullAccount != null) {
                showOperations(fullAccount);
            } else {
                System.out.println("Unexpected error: account not found after login");
            }

        } else {
            System.out.println("Account not logged in");
        }
    }

    /**
     * Displays the main menu for the logged-in user and handles wallet operations.
     *
     * @param account the logged-in account
     */
    private void showOperations(Account account) {
        while (true) {
            System.out.println(EWallet.name); // Display wallet name (static constant)
            System.out.println("Your balance is: " + account.getBalance() + " EG");
            System.out.println("Welcome again :" + account.getUserName());

            System.out.println("\nChoose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Logout");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    double depAmount = sc.nextDouble();
                    if (accountService.deposit(account.getUserName(), depAmount)) {
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Deposit failed.");
                    }
                    break;

                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double wdAmount = sc.nextDouble();
                    if (accountService.withdraw(account.getUserName(), wdAmount)) {
                        System.out.println("Withdraw successful.");
                    } else {
                        System.out.println("Withdraw failed. Check balance.");
                    }
                    break;

                case 3:
                    System.out.println("Enter recipient username:");
                    String toUser = sc.next();

                    System.out.println("Enter amount to transfer:");
                    double trAmount = sc.nextDouble();

                    if (accountService.transfer(account.getUserName(), toUser, trAmount)) {
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Transfer failed. Check balance or username.");
                    }
                    break;

                case 4:
                    System.out.println("Logging out...");
                    return; // Exit loop to logout
                default:
                    System.out.println("Invalid choice");
            }

            // Display updated balance after each operation
            System.out.println("Current Balance: " + account.getBalance() + " EG");
        }
    }
}
