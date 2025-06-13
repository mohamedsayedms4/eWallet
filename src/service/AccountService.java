package service;

import model.Account;

/**
 * AccountService interface defines the core operations
 * that can be performed on an Account in the EWallet system.
 */
public interface AccountService {

    /**
     * Creates a new account and adds it to the system.
     *
     * @param account the account to be created
     * @return true if account is successfully created, false otherwise
     */
    boolean createAccount(Account account);

    /**
     * Validates login credentials for a user.
     *
     * @param account the account containing username and password to verify
     * @return true if login is successful, false otherwise
     */
    boolean login(Account account);

    /**
     * Deposits a specified amount into the given user's account.
     *
     * @param userName the username of the account
     * @param amount the amount to be deposited
     * @return true if deposit is successful, false otherwise
     */
    boolean deposit(String userName, double amount);

    /**
     * Withdraws a specified amount from the given user's account.
     *
     * @param userName the username of the account
     * @param amount the amount to be withdrawn
     * @return true if withdrawal is successful, false otherwise
     */
    boolean withdraw(String userName, double amount);

    /**
     * Transfers a specified amount from one account to another.
     *
     * @param fromAccount the username of the sender account
     * @param toAccount the username of the recipient account
     * @param amount the amount to be transferred
     * @return true if transfer is successful, false otherwise
     */
    boolean transfer(String fromAccount, String toAccount, double amount);

    /**
     * Retrieves an account by its username.
     *
     * @param username the username to search for
     * @return the Account object if found, null otherwise
     */
    Account getAccountByUsername(String username);
}
