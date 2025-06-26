package service.implementation;

import model.EWallet;
import service.ApplicationService;
import service.LoginService;
import service.SignUpService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService {

    private Scanner scanner = new Scanner(System.in);
    private EWallet eWallet = EWallet.getInstance();

    private SignUpService signUpService = new SignUpServiceImpl();
    private LoginService loginService = new LoginServiceImpl();

    @Override
    public void startEWalletSystem() {
        System.out.println("Welcome to the " + eWallet.getName() + " !");

        int counter = 3;

        while (counter != 0) {
            try {
                System.out.println("Please choose:");
                System.out.println("1. Sign up     2. Login     3. Logout");
                System.out.print("Your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        signUpService.signUp();
                        break;
                    case 2:
                        loginService.Login();
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                        counter--;
                        break;
                }

            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear the invalid input
                counter--;
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                counter--;
            }
        }

        if (counter == 0) {
            System.out.println("Too many invalid attempts. Please try again later...");
        }
    }
}
