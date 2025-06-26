package service.implementation;

import model.Account;
import service.AccountService;
import service.LoginService;
import service.ValidationService;
import service.loginFeatures;

import java.util.Objects;
import java.util.Scanner;

/**
 * Implementation of login service that handles user authentication.
 */
public class LoginServiceImpl implements LoginService {

    private Scanner scanner = new Scanner(System.in);
    private AccountService accountService = new AccountServiceImpl();
    private ValidationService validationService = new ValidationServiceImpl();

    /**
     * Handles the user login process by validating credentials,
     * verifying account existence, and then proceeding to user-specific features.
     */
    @Override
    public void Login() {
        try {
            // Validate login credentials and create an Account object if valid
            Account account = validationService.validateLoginAccount();

            // If validation fails, exit the method
            if (Objects.isNull(account)) {
                System.out.println("Validation failed. Please try again.");
                return;
            }

            // Check if account exists and credentials match
            boolean isLoginAccount = accountService.LoginAccount(account);

            if (!isLoginAccount) {
                System.out.println("Invalid username or password.");
            } else {
                System.out.println("Logged in successfully. Welcome back, " + account.getUserName());

                // Retrieve the full account details from the system
                Account actualAccount = accountService.getAccountByUserName(account);

                // Navigate to logged-in user features
                loginFeatures loginFeatures = new loginFeaturesImpl();
                loginFeatures.loginFeatures(actualAccount);
            }

        } catch (Exception e) {
            System.out.println("An unexpected error occurred during login: " + e.getMessage());
        }
    }
}
