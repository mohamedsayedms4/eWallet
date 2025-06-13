package model;

import java.util.ArrayList;
import java.util.List;

public class EWallet {
    public static final String name = "VODAFONE";

    // Singleton instance
    private static EWallet instance;

    // List of all accounts
    private List<Account> accounts = new ArrayList<>();

    private EWallet() {}

    // Singleton pattern - get instance
    public static EWallet getInstance() {
        if (instance == null) {
            instance = new EWallet();
        }
        return instance;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
