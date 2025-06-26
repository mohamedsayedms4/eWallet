package service.implementation;

import model.Account;
import service.ValidationService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidationServiceImpl implements ValidationService {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public boolean isValidUserName(String userName) {
        return userName.length() >= 3 && Character.isUpperCase(userName.charAt(0));
    }

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
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if ("#$@&".indexOf(ch) >= 0) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= 18 && age <= 80;
    }

    @Override
    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null
                && phoneNumber.length() == 12
                && phoneNumber.startsWith("2")
                && phoneNumber.chars().allMatch(Character::isDigit);
    }

    @Override
    public Account validateCreateAccount() {
        try {
            System.out.println("Please enter your user name:");
            String userName = scanner.nextLine();
            if (!isValidUserName(userName)) {
                System.out.println("Invalid user name. It must be at least 3 characters and start with an uppercase letter.");
                return null;
            }

            System.out.println("Please enter your password:");
            String password = scanner.nextLine();
            if (!isValidPassword(password)) {
                System.out.println("Invalid password. It must be at least 6 characters and contain uppercase, lowercase, digit, and one of these: # $ @ &");
                return null;
            }

            System.out.println("Please enter your age:");
            int age;
            try {
                age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Age must be a number.");
                scanner.nextLine(); // Clear invalid input
                return null;
            }

            if (!isValidAge(age)) {
                System.out.println("Invalid age. Must be between 18 and 80.");
                return null;
            }

            System.out.println("Please enter your phone number:");
            String number = scanner.nextLine();
            if (!isValidPhoneNumber(number)) {
                System.out.println("Invalid phone number. Must start with '2' and be exactly 12 digits.");
                return null;
            }

            return new Account.AccountBuilder(userName, password, number, age).build();

        } catch (Exception e) {
            System.out.println("Unexpected error during account creation: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Account validateLoginAccount() {
        try {
            System.out.println("Please enter your user name:");
            String userName = scanner.nextLine();
            if (!isValidUserName(userName)) {
                System.out.println("Invalid user name. It must be at least 3 characters and start with an uppercase letter.");
                return null;
            }

            System.out.println("Please enter your password:");
            String password = scanner.nextLine();
            if (!isValidPassword(password)) {
                System.out.println("Invalid password. It must be at least 6 characters and contain uppercase, lowercase, digit, and one of these: # $ @ &");
                return null;
            }

            return new Account.AccountBuilder(userName, password).build();

        } catch (Exception e) {
            System.out.println("Unexpected error during login validation: " + e.getMessage());
            return null;
        }
    }
}
