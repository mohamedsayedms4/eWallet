package service;

import model.Account;

import java.util.List;

public class SimpleLoginStrategyImp implements LoginStrategy {

    @Override
    public boolean login(List<Account> accounts, Account input) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(input.getUserName()) &&
                    acc.getPassword().equals(input.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
