package service;

import model.Account;

import java.util.List;

public interface LoginStrategy {
    boolean login(List<Account> accounts, Account input);

}
