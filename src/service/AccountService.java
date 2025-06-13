package service;

import model.Account;

public interface AccountService {

    boolean createAccount(Account account) ;
    boolean login(Account account);
}
