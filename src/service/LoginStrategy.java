package service;

import model.Account;
import java.util.List;

/**
 * LoginStrategy is a strategy interface that defines a method for user authentication.
 * This allows for different implementations of login logic using the Strategy Design Pattern.
 */
public interface LoginStrategy {

    /**
     * Attempts to authenticate a user based on a list of accounts and an input account.
     *
     * @param accounts List of all registered accounts.
     * @param input The account containing user-provided credentials (username and password).
     * @return true if login is successful, false otherwise.
     */
    boolean login(List<Account> accounts, Account input);
}
