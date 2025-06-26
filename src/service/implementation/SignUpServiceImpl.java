package service.implementation;

import model.Account;
import service.AccountService;
import service.SignUpService;
import service.ValidationService;

import java.util.Objects;
import java.util.Scanner;

/**
 * Implementation of signup service that handles user registration.
 */
public class SignUpServiceImpl implements SignUpService {

    private Scanner scanner = new Scanner(System.in);
    private AccountService accountService = new AccountServiceImpl();
    private ValidationService validationService = new ValidationServiceImpl();

    /**
     * Handles the user signup process by validating input data,
     * creating a new account, and notifying the user of the outcome.
     */
    @Override
    public void signUp() {
        try {
            // Validate input data and create a new Account object
            Account account = validationService.validateCreateAccount();

            // If validation fails, exit the method
            if (Objects.isNull(account)) {
                System.out.println("Validation failed. Please try again.");
                return;
            }

            // Try to create the account in the system
            boolean isCreatedAccount = accountService.createAccount(account);

            // Inform user about the creation result
            if (!isCreatedAccount) {
                System.out.println("Account creation failed: This username may already be taken.");
            } else {
                System.out.println("Account created successfully. You can now log in.");
            }

        } catch (Exception e) {
            System.out.println("An unexpected error occurred during signup: " + e.getMessage());
        }
    }
}
