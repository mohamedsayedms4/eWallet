package service;

import model.Account;

/**
 * Interface defining validation operations for user account data.
 */
public interface ValidationService {

    /**
     * Validates if the given username meets required rules.
     * @param userName the username to validate
     * @return true if valid, false otherwise
     */
    boolean isValidUserName(String userName);

    /**
     * Validates if the given password meets required rules.
     * @param password the password to validate
     * @return true if valid, false otherwise
     */
    boolean isValidPassword(String password);

    /**
     * Validates if the given age is within acceptable limits.
     * @param age the age to validate
     * @return true if valid, false otherwise
     */
    boolean isValidAge(int age);

    /**
     * Validates if the given phone number format is correct.
     * @param phoneNumber the phone number to validate
     * @return true if valid, false otherwise
     */
    boolean isValidPhoneNumber(String phoneNumber);

    /**
     * Validates user input to create a new Account object.
     * @return the Account object if input is valid, otherwise null
     */
    Account validateCreateAccount();

    /**
     * Validates user input for login.
     * @return the Account object if input is valid, otherwise null
     */
    Account validateLoginAccount();
}
