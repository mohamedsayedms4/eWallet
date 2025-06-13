package service;

import model.Account;

import java.util.Scanner;

public class ApplicationServiceImp implements ApplicationService {
    Scanner sc = new Scanner(System.in);
    AccountService accountService = new AccountServiceImp();

    @Override
    public void start() {
        System.out.println("Welcome Sir");

        int  testCases = 3;
        while (testCases>0) {
            System.out.println("please choose one of the following options:");
            System.out.println("1. sign up     2. sign in");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    signUp();
                    signIn();
                    break;
                case 2:
                    signIn();
                    break;
                default:
                    System.out.println("Invalid choice");
                    testCases--;
            }

            if(0 == testCases){
                System.out.println("please try again another time");
            }

        }
    }

    private void signUp() {
        System.out.println("please Enter your name");
        String userName = sc.next();
        System.out.println("please Enter your password");
        String password = sc.next();
        System.out.println("please Enter your Full Number");
        String fullNumber = sc.next();
        System.out.println("please enter your Age");
        int age = sc.nextInt();

        Account account = new Account(userName, password, fullNumber, age);
        boolean isCreatedAccount = accountService.createAccount(account);
        if(isCreatedAccount){
            System.out.println("Account created");
        }else {
            System.out.println("Account not created");
        }
    }

    private void signIn() {
        System.out.println("please Enter your name");
        String userName = sc.next();
        System.out.println("please Enter your password");
        String password = sc.next();
        Account account = new Account(userName, password);
        boolean isLoginedAccount = accountService.login(account);
        if(isLoginedAccount){
            System.out.println("Account logged in");
        }else {
            System.out.println("Account not logged in");
        }
    }


}
