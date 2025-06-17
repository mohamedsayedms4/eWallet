package service.implementation;

import model.EWallet;
import service.ApplicationService;
import service.LoginService;
import service.SignUpService;

import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService {

    // Scanner for user input
    private Scanner scanner = new Scanner(System.in);

    // Singleton instance of EWallet
    private EWallet eWallet = EWallet.getInstance();

    // Services for sign up and login
    private SignUpService signUpService = new SignUpServiceImpl();
    private LoginService loginService = new LoginServiceImpl();

    @Override
    public void startEWalletSystem() {
        System.out.println("Welcome to the "+ eWallet.getName()+" !");

        int counter = 3;

        // Main loop for user options
        while (0 != counter) {
            System.out.println("please choose.");
            System.out.println("1.signup     2.login   3.logout");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Handle sign up
                    signUpService.signUp();
                    break;
                case 2:
                    // Handle login
                    loginService.Login();
                    break;
                case 3:
                    // Exit the system
                    return;
                default:
                    // Invalid input handling
                    System.out.println("invalid choice");
                    counter--;
                    break;
            }
        }

        // User exceeded maximum invalid attempts
        if (0 == counter) {
            System.out.println("please try later .....");
        }
    }
}
