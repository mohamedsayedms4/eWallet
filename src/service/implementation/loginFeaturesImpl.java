package service.implementation;

import model.Account;
import service.AccountService;
import service.loginFeatures;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implementation of post-login features for an account.
 */
public class loginFeaturesImpl implements loginFeatures {

    AccountService accountService = new AccountServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void loginFeatures(Account account) {
        int counter = 3;
        while (counter != 0) {
            try {
                System.out.println("Please choose:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer");
                System.out.println("4. Show Account Details");
                System.out.println("5. Change Password");
                System.out.println("6. Logout");

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
                        deposit(account);
                        break;
                    case 2:
                        withdraw(account);
                        break;
                    case 3:
                        transfer(account);
                        break;
                    case 4:
                        accountService.showAccountDetails(account);
                        break;
                    case 5:
                        changePassword(account);
                        break;
                    case 6:
                        System.out.println("Logging out...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                        counter--;
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input type. Please try again.");
                scanner.next(); // clear invalid input
                counter--;
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                counter--;
            }
        }

        System.out.println("Too many invalid attempts. Please try again later.");
    }

    private void changePassword(Account account) {
        try {
            System.out.println("Enter old password:");
            String oldPassword = scanner.nextLine();

            System.out.println("Enter new password:");
            String newPassword = scanner.nextLine();

            boolean changed = accountService.changePassword(account, oldPassword, newPassword);
            System.out.println(changed ? "Password changed successfully." : "Failed to change password.");
        } catch (Exception e) {
            System.out.println("Error while changing password: " + e.getMessage());
        }
    }

    private void transfer(Account account) {
        try {
            System.out.println("Enter transfer amount:");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid amount.");
                scanner.next();
                return;
            }
            double amount = scanner.nextDouble();
            scanner.nextLine();
            if (amount <= 0) {
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

            boolean transferred = accountService.transferMoney(account, toAccount, amount);
            System.out.println(transferred ? "Transfer successful. Balance: " + account.getBalance() : "Transfer failed.");
        } catch (Exception e) {
            System.out.println("Error during transfer: " + e.getMessage());
        }
    }

    private void withdraw(Account account) {
        try {
            System.out.println("Enter withdrawal amount:");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid amount.");
                scanner.next();
                return;
            }
            double amount = scanner.nextDouble();
            scanner.nextLine();
            if (amount <= 0) {
                System.out.println("Amount must be positive.");
                return;
            }

            int result = accountService.withdraw(account, amount);
            switch (result) {
                case 1:
                    System.out.println("Account not found.");
                    break;
                case 2:
                    System.out.println("Insufficient balance.");
                    break;
                case 3:
                    System.out.println("Withdrawal successful. Balance: " + account.getBalance());
                    break;
                default:
                    System.out.println("Withdrawal failed.");
            }
        } catch (Exception e) {
            System.out.println("Error during withdrawal: " + e.getMessage());
        }
    }

    private void deposit(Account account) {
        try {
            System.out.println("Enter deposit amount:");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid amount.");
                scanner.next();
                return;
            }
            double amount = scanner.nextDouble();
            scanner.nextLine();
            if (amount <= 0) {
                System.out.println("Amount must be positive.");
                return;
            }

            boolean success = accountService.deposit(account, amount);
            System.out.println(success ? "Deposit successful. Balance: " + account.getBalance() : "Deposit failed.");
        } catch (Exception e) {
            System.out.println("Error during deposit: " + e.getMessage());
        }
    }
}
