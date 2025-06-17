package model;

import java.util.ArrayList;
import java.util.List;

public class EWallet {

    // Constant name for the e-wallet
    private final String name = "eraa-soft";

    // Singleton instance of EWallet
    private static EWallet instance;

    // List to store all accounts linked to the e-wallet
    private List<Account> accounts = new ArrayList<Account>();

    // Getter for wallet name
    public String getName() {
        return name;
    }

    // Private constructor to prevent instantiation from outside (Singleton pattern)
    private EWallet() {}

    // Method to get the single instance of EWallet (thread-safe lazy initialization)
    public static EWallet getInstance() {
        if (instance == null) {
            synchronized (EWallet.class) {
                if (instance == null) {
                    instance = new EWallet();
                }
            }
        }
        return instance;
    }

    // Getter for the list of accounts
    public List<Account> getAccounts() {
        return accounts;
    }

    // Setter to replace the entire list of accounts
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    // Overridden toString method to represent the EWallet object as a string
    @Override
    public String toString() {
        return "EWallet{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
