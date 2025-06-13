package service;

import model.Account;
import model.EWallet;

import java.util.List;

/**
 * AccountServiceImp provides the concrete implementation of AccountService interface.
 * It handles operations such as creating accounts, logging in, depositing,
 * withdrawing, and transferring money.
 */
public class AccountServiceImp implements AccountService {

    // Singleton instance of the EWallet to manage all accounts
    private final EWallet ewallet = EWallet.getInstance();

    /**
     * Adds a new account to the EWallet.
     *
     * @param account the account to be added
     * @return true if added successfully
     */
    @Override
    public boolean createAccount(Account account) {
        ewallet.getAccounts().add(account);
        return true;
    }

    // Login strategy used for authentication (Strategy Design Pattern)
    private LoginStrategy loginStrategy = new SimpleLoginStrategyImp();

    /**
     * Authenticates a user using the login strategy.
     *
     * @param account contains username and password
     * @return true if authentication is successful
     */
    @Override
    public boolean login(Account account) {
        return loginStrategy.login(ewallet.getAccounts(), account);
    }

    /**
     * Deposits an amount into a user's account.
     *
     * @param userName the username of the account
     * @param amount the amount to deposit
     * @return true if the operation is successful
     */
    @Override
    public boolean deposit(String userName, double amount) {
        for (Account acc : ewallet.getAccounts()) {
            if (acc.getUserName().equals(userName)) {
                acc.setBalance(acc.getBalance() + amount);
                return true;
            }
        }
        return false;
    }

    /**
     * Withdraws an amount from a user's account.
     *
     * @param userName the username of the account
     * @param amount the amount to withdraw
     * @return true if the operation is successful
     */
    @Override
    public boolean withdraw(String userName, double amount) {
        for (Account acc : ewallet.getAccounts()) {
            if (acc.getUserName().equals(userName)) {
                acc.setBalance(acc.getBalance() - amount);
                return true;
            }
        }
        return false;
    }

    /**
     * Transfers an amount from one user's account to another.
     *
     * @param fromAccount sender's username
     * @param toAccount receiver's username
     * @param amount the amount to transfer
     * @return true if transfer is successful
     */
    @Override
    public boolean transfer(String fromAccount, String toAccount, double amount) {
        Account sender = null, receiver = null;

        for (Account acc : ewallet.getAccounts()) {
            if (acc.getUserName().equals(fromAccount)) {
                sender = acc;
            } else if (acc.getUserName().equals(toAccount)) {
                receiver = acc;
            }
        }

        if (sender != null && receiver != null) {
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Retrieves an account by username.
     *
     * @param username the username to search for
     * @return the Account object if found, null otherwise
     */
    @Override
    public Account getAccountByUsername(String username) {
        for (Account acc : ewallet.getAccounts()) {
            if (acc.getUserName().equals(username)) {
                return acc;
            }
        }
        return null;
    }
}
