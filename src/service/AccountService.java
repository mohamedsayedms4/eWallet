package service;

import model.Account;

public interface AccountService {

    /**
     * Creates a new account.
     * @param account The account to be created.
     * @return true if the account is successfully created, false otherwise.
     */
    boolean createAccount(Account account);

    /**
     * Verifies login credentials of an account.
     * @param account The account with username and password to validate.
     * @return true if the login is successful, false otherwise.
     */
    boolean LoginAccount(Account account);

    /**
     * Deposits money into the specified account.
     * @param account The account to deposit money into.
     * @param money The amount to deposit.
     * @return true if the deposit is successful, false otherwise.
     */
    boolean deposit(Account account, double money);

    /**
     * Withdraws money from the specified account.
     * @param account The account to withdraw money from.
     * @param money The amount to withdraw.
     * @return 1 if success, 0 or negative if failed (e.g. insufficient balance).
     */
    int withdraw(Account account, double money);

    /**
     * Transfers money from one account to another.
     * @param from The account to transfer money from.
     * @param to The account to transfer money to.
     * @param money The amount to transfer.
     * @return true if the transfer is successful, false otherwise.
     */
    boolean transferMoney(Account from, Account to, double money);

    /**
     * Retrieves the actual account details from the database using an Account object.
     * @param account An account object containing the username.
     * @return The full account details if found, null otherwise.
     */
    Account getAccountByUserName(Account account);

    /**
     * Retrieves the actual account details from the database using a username.
     * @param userName The username of the account.
     * @return The full account details if found, null otherwise.
     */
    Account getAccountByUserName(String userName);

    /**
     * Displays the details of the specified account.
     * @param account The account whose details are to be shown.
     */
    void showAccountDetails(Account account);

    /**
     * Changes the password of the given account.
     * @param account The account to update.
     * @param oldPassword The current password.
     * @param newPassword The new password.
     * @return true if the password was successfully changed, false otherwise.
     */
    boolean changePassword(Account account, String oldPassword, String newPassword);
}
