package service.implementation;

import model.Account;
import service.AccountService;
import service.LoginService;
import service.ValidationService;
import service.loginFeatures;

import java.util.Objects;
import java.util.Scanner;

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
        // Validate login credentials and create an Account object if valid
        Account account = validationService.validateLoginAccount();

        // If validation fails, exit the method
        if(Objects.isNull(account)) {
            return;
        }

        // Check if account exists and credentials match
        boolean isLoginAccount = accountService.LoginAccount(account);

        if (!isLoginAccount) {
            System.out.println("Invalid username or password");
        } else {
            System.out.println("Logged in welcome again " + account.getUserName());

            // Retrieve the full account details from the system
            Account actualAccount = accountService.getAccountByUserName(account);

            // Initialize login features and navigate to logged-in user options
            loginFeatures loginFeatures = new loginFeaturesImpl();
            loginFeatures.loginFeatures(actualAccount);
        }
    }
}
