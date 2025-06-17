package service.implementation;

import model.Account;
import service.AccountService;
import service.loginFeatures;

import java.util.Scanner;

/**
 * Implementation of post-login features for an account.
 */
public class loginFeaturesImpl implements loginFeatures {

    AccountService accountService = new AccountServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    /**
     * Displays and handles the operations available after user login.
     */
    @Override
    public void loginFeatures(Account account) {
        int counter = 3;
        while (counter != 0) {
            System.out.println("Please choose:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Show Account Details");
            System.out.println("5. Change Password");
            System.out.println("6. Logout");

            // Validate input is integer
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 6.");
                scanner.next(); // clear invalid input
                counter--;
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    deposit(account); // Handle deposit
                    break;
                case 2:
                    withdraw(account); // Handle withdraw
                    break;
                case 3:
                    transfer(account); // Handle transfer
                    break;
                case 4:
                    accountService.showAccountDetails(account); // Show account info
                    break;
                case 5:
                    changePassword(account); // Handle password change
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    counter--;
                    break;
            }
        }

        if (counter == 0) {
            System.out.println("Too many invalid attempts. Please try again later.");
        }
    }

    /**
     * Allows user to change their password.
     */
    private void changePassword(Account account) {
        System.out.println("Enter old password:");
        String oldPassword = scanner.nextLine();

        System.out.println("Enter new password:");
        String newPassword = scanner.nextLine();

        boolean changed = accountService.changePassword(account, oldPassword, newPassword);
        if (changed) {
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Failed to change password.");
        }
    }

    /**
     * Transfers money to another account by username.
     */
    private void transfer(Account account) {
        System.out.println("Enter transfer amount:");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.next();
            return;
        }
        double transfer = scanner.nextDouble();
        scanner.nextLine();
        if (transfer <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        System.out.println("Enter recipient username:");
        String toUserName = scanner.nextLine().trim();
        Account toAccount = accountService.getAccountByUserName(toUserName);
        if (toAccount == null) {
            System.out.println("Recipient not found.");
            return;
        }

        boolean transferred = accountService.transferMoney(account, toAccount, transfer);
        if (transferred) {
            System.out.println("Transfer successful. Balance: " + account.getBalance());
        } else {
            System.out.println("Transfer failed.");
        }
    }

    /**
     * Handles withdrawal operation for an account.
     */
    private void withdraw(Account account) {
        System.out.println("Enter withdrawal amount:");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.next();
            return;
        }
        double withdraw = scanner.nextDouble();
        scanner.nextLine();
        if (withdraw <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        int result = accountService.withdraw(account, withdraw);
        if (result == 1) {
            System.out.println("Account not found.");
        } else if (result == 2) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal successful. Balance: " + account.getBalance());
        }
    }

    /**
     * Handles deposit operation for an account.
     */
    private void deposit(Account account) {
        System.out.println("Enter deposit amount:");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.next();
            return;
        }
        double deposit = scanner.nextDouble();
        scanner.nextLine();
        if (deposit <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        if (accountService.deposit(account, deposit)) {
            System.out.println("Deposit successful. Balance: " + account.getBalance());
        } else {
            System.out.println("Deposit failed.");
        }
    }
}
