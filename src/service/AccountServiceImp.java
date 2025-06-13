package service;

import model.Account;
import model.EWallet;

import java.util.List;

public class AccountServiceImp implements AccountService {

    private final EWallet ewallet = EWallet.getInstance();
    @Override
    public boolean createAccount(Account account) {
        ewallet.getAccounts().add(account);
        return true;
    }

    private LoginStrategy loginStrategy = new SimpleLoginStrategyImp();
    @Override
    public boolean login(Account account) {
       return loginStrategy.login(ewallet.getAccounts(), account);
    }
}
