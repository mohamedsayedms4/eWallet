package service;

import model.Account;
import java.util.List;

/**
 * SimpleLoginStrategyImp is a concrete implementation of the LoginStrategy interface.
 * It performs basic authentication by matching username and password exactly.
 */
public class SimpleLoginStrategyImp implements LoginStrategy {

    /**
     * Attempts to authenticate a user by checking if the username and password
     * match any account in the provided list.
     *
     * @param accounts List of existing accounts in the system.
     * @param input Account object containing the username and password provided by the user.
     * @return true if a matching account is found; false otherwise.
     */
    @Override
    public boolean login(List<Account> accounts, Account input) {
        for (Account acc : accounts) {
            // Check if both username and password match
            if (acc.getUserName().equals(input.getUserName()) &&
                    acc.getPassword().equals(input.getPassword())) {
                return true; // Successful login
            }
        }
        return false; // No match found
    }
}
