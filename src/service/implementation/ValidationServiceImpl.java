package service.implementation;

import model.Account;
import service.ValidationService;

import java.util.Scanner;

public class ValidationServiceImpl implements ValidationService {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Checks if the username is valid:
     * - length >= 3
     * - starts with an uppercase letter
     * @param userName the username to validate
     * @return true if valid, false otherwise
     */
    @Override
    public boolean isValidUserName(String userName) {
        return userName.length() >= 3
                && Character.isUpperCase(userName.charAt(0));
    }

    /**
     * Validates the password according to these rules:
     * - at least 6 characters
     * - contains at least one uppercase letter
     * - contains at least one lowercase letter
     * - contains at least one digit
     * - contains at least one special character from #$@&
     * @param password the password to validate
     * @return true if valid, false otherwise
     */
    @Override
    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 6) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if ("#$@&".indexOf(ch) >= 0) {
                hasSpecial = true;
            }
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    /**
     * Validates if the age is within the range [18, 80].
     * @param age the age to validate
     * @return true if valid, false otherwise
     */
    @Override
    public boolean isValidAge(int age) {
        return age >= 18 && age <= 80;
    }

    /**
     * Validates the phone number:
     * - must be 12 characters long
     * - must start with '2'
     * - all characters must be digits
     * @param phoneNumber the phone number to validate
     * @return true if valid, false otherwise
     */
    @Override
    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null
                && phoneNumber.length() == 12
                && phoneNumber.startsWith("2")
                && phoneNumber.chars().allMatch(Character::isDigit);
    }

    /**
     * Prompts user input to create and validate a new Account.
     * Returns the Account if all inputs are valid; otherwise returns null.
     * @return validated Account or null if input invalid
     */
    @Override
    public Account validateCreateAccount() {

        System.out.println("Please enter your user name ");
        String userName = scanner.nextLine();
        if (!isValidUserName(userName)) {
            System.out.println("Invalid user name.");
            System.out.println("Username must be at least 3 characters and start with an uppercase letter.");
            return null;
        }

        System.out.println("Please enter your password");
        String password = scanner.nextLine();
        if (!isValidPassword(password)) {
            System.out.println("Invalid password.");
            System.out.println("Password must be at least 6 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character (#, $, @, &).");
            return null;
        }

        System.out.println("Please enter your age");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (!isValidAge(age)) {
            System.out.println("Invalid age.");
            System.out.println("Age must be between 18 and 80.");
            return null;
        }

        System.out.println("Please enter your phone number");
        String number = scanner.nextLine();
        if (!isValidPhoneNumber(number)) {
            System.out.println("Invalid phone number.");
            System.out.println("Phone number must start with '2' and be exactly 12 digits long.");
            return null;
        }

        return new Account.AccountBuilder(userName, password, number, age).build();
    }

    /**
     * Prompts user input to validate login credentials.
     * Returns the Account if valid; otherwise returns null.
     * @return validated Account or null if input invalid
     */
    @Override
    public Account validateLoginAccount() {
        System.out.println("Please enter your user name ");
        String userName = scanner.nextLine();
        if (!isValidUserName(userName)) {
            System.out.println("Invalid user name.");
            System.out.println("Username must be at least 3 characters and start with an uppercase letter.");
            return null;
        }

        System.out.println("Please enter your password");
        String password = scanner.nextLine();
        if (!isValidPassword(password)) {
            System.out.println("Invalid password.");
            System.out.println("Password must be at least 6 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character (#, $, @, &).");
            return null;
        }

        return new Account.AccountBuilder(userName, password).build();
    }
}
