package service.implementation;

import model.Account;
import model.EWallet;
import service.AccountService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService {

    private Scanner scanner = new Scanner(System.in);
    private EWallet eWallet = EWallet.getInstance();
//    private AccountService accountService = new AccountServiceImpl();

    /**
     * Creates a new account if it doesn't already exist.
     */
    @Override
    public boolean createAccount(Account account) {
        if (checkIfAccountExists(account) != -1) {
            return false;
        }
        eWallet.getAccounts().add(account);
        return true;
    }

    /**
     * Checks login credentials (username and password).
     */
    @Override
    public boolean LoginAccount(Account account) {
        List<Account> accounts = eWallet.getAccounts();
        for (Account acc : accounts) {
            if (acc.getUserName().equals(account.getUserName()) &&
                    acc.getPassword().equals(account.getPassword())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the account already exists in the system.
     */
    private int checkIfAccountExists(Account account) {
        List<Account> accounts = eWallet.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(account.getUserName())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adds money to the specified account.
     */
    @Override
    public boolean deposit(Account account, double money) {
        int accountIndex = checkIfAccountExists(account);
        if (accountIndex == -1) {
            return false;
        }
        eWallet.getAccounts().get(accountIndex).setBalance(
                eWallet.getAccounts().get(accountIndex).getBalance() + money
        );
        return true;
    }

    /**
     * Withdraws money from the account if sufficient balance is available.
     * Return codes:
     * 1 = account not found
     * 2 = insufficient balance
     * 3 = success
     */
    @Override
    public int withdraw(Account account, double money) {
        int accountIndex = checkIfAccountExists(account);
        if (accountIndex == -1) {
            return 1;
        }

        if (!(eWallet.getAccounts().get(accountIndex).getBalance() >= money)) {
            return 2;
        }

        eWallet.getAccounts().get(accountIndex).setBalance(
                eWallet.getAccounts().get(accountIndex).getBalance() - money
        );

        return 3;
    }

    /**
     * Transfers money from one account to another.
     */
    @Override
    public boolean transferMoney(Account from, Account to, double money) {
        int fromIndex = checkIfAccountExists(from);
        int toIndex = checkIfAccountExists(to);

        if (fromIndex == -1 || toIndex == -1) {
            System.out.println("One of the accounts does not exist.");
            return false;
        }

        double fromBalance = eWallet.getAccounts().get(fromIndex).getBalance();
        if (fromBalance < money) {
            System.out.println("Insufficient balance.");
            return false;
        }

        eWallet.getAccounts().get(fromIndex).setBalance(fromBalance - money);

        double toBalance = eWallet.getAccounts().get(toIndex).getBalance();
        eWallet.getAccounts().get(toIndex).setBalance(toBalance + money);

        System.out.println("Transfer successful.");
        return true;
    }

    /**
     * Retrieves an account by object reference.
     */
    @Override
    public Account getAccountByUserName(Account account) {
        int accountIndex = checkIfAccountExists(account);
        if (accountIndex == -1) {
            return null;
        }
        return eWallet.getAccounts().get(accountIndex);
    }

    /**
     * Retrieves an account by username string.
     */
    @Override
    public Account getAccountByUserName(String userName) {
        for (Account acc : eWallet.getAccounts()) {
            if (acc.getUserName().equals(userName)) {
                return acc;
            }
        }
        return null;
    }

    /**
     * Displays account details.
     */
    @Override
    public void showAccountDetails(Account account) {
        getAccountByUserName(account);
        if (Objects.isNull(account)) {
            System.out.println("account not exist to show profile details");
            return;
        }
        System.out.println("-> userName:     " + account.getUserName());
        System.out.println("-> password:     " + account.getPassword());
        System.out.println("-> age:          " + account.getAge());
        System.out.println("-> phone number: " + account.getPhoneNumber());
        System.out.println("-> Balance:      " + account.getBalance());
    }

    /**
     * Changes password of the account if old password matches.
     */
    @Override
    public boolean changePassword(Account account, String oldPassword, String newPassword) {
        int index = checkIfAccountExists(account);
        if (index == -1) {
            System.out.println("Account not found.");
            return false;
        }

        Account currentAccount = eWallet.getAccounts().get(index);

        if (!currentAccount.getPassword().equals(oldPassword)) {
            System.out.println("Old password is incorrect.");
            return false;
        }

        // Optional: You can add new password validation here.
        currentAccount.setPassword(newPassword);
        System.out.println("Password changed successfully.");
        return true;
    }
}
