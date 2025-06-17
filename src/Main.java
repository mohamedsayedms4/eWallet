import model.Account;
import model.EWallet;
import service.ApplicationService;
import service.implementation.ApplicationServiceImpl;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Account acc1 =new Account.AccountBuilder("Ahmed","pass123!َِAQ#", "201010000001",19)
                .setEmail("ahmed@example.com")
                .setAddress("Cairo")
                .setNationalId("29801011234567")
                .build();

        Account acc2 =  new  Account.AccountBuilder("Khaled","admin123!َِAQ#", "201010000004", 30)
                .setEmail("khaled@company.com")
                .setAddress("Ismailia")
                .setNationalId("28011013456789")
                .build();

        Account acc3 =  new Account.AccountBuilder("Nour","Mohamed&&150", "201010000005", 27)
                .setEmail("nour@sample.com")
                .setAddress("Luxor")
                .setNationalId("29703333456789")
                .build();

        Account acc4 = new Account.AccountBuilder("Khaled","admin123!َِAQ#")
                .setEmail("khaled@company.com")
                .setAddress("Ismailia")
                .setNationalId("28011013456789")
                .build();

        Account acc5 = new Account.AccountBuilder("Nour","Mohamed&&150", "0100000005", 27)
                .setEmail("nour@sample.com")
                .setAddress("Luxor")
                .setNationalId("29703333456789")
                .build();


        System.out.println(acc1.getBalance());
        EWallet eWallet = EWallet.getInstance();
        eWallet.getAccounts().add(acc1);
        eWallet.getAccounts().add(acc2);
        eWallet.getAccounts().add(acc3);
        eWallet.getAccounts().add(acc4);
        eWallet.getAccounts().add(acc5);

        /* --------------------------------------------------------------------------------------*/

        new ApplicationServiceImpl().startEWalletSystem();

    }
}