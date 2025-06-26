package service.implementation;

import model.Account;
import model.EWallet;
import service.AccountService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService {

    private Scanner scanner = new Scanner(System.in);
    private EWallet eWallet = EWallet.getInstance();

    @Override
    public boolean createAccount(Account account) {
        try {
            if (checkIfAccountExists(account) != -1) {
                return false;
            }
            eWallet.getAccounts().add(account);
            return true;
        } catch (Exception e) {
            System.out.println("Error creating account: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean LoginAccount(Account account) {
        try {
            int index = checkIfAccountExists(account);
            if (index == -1) return false;
            Account existingAccount = eWallet.getAccounts().get(index);
            return existingAccount.getPassword().equals(account.getPassword());
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
            return false;
        }
    }

    private int checkIfAccountExists(Account account) {
        try {
            List<Account> accounts = eWallet.getAccounts();
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getUserName().equals(account.getUserName())) {
                    return i;
                }
            }
        } catch (Exception e) {
            System.out.println("Error checking account: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public boolean deposit(Account account, double money) {
        try {
            int accountIndex = checkIfAccountExists(account);
            if (accountIndex == -1) return false;
            Account acc = eWallet.getAccounts().get(accountIndex);
            acc.setBalance(acc.getBalance() + money);
            return true;
        } catch (Exception e) {
            System.out.println("Error during deposit: " + e.getMessage());
            return false;
        }
    }

    @Override
    public int withdraw(Account account, double money) {
        try {
            int accountIndex = checkIfAccountExists(account);
            if (accountIndex == -1) return 1;

            Account acc = eWallet.getAccounts().get(accountIndex);
            if (acc.getBalance() < money) return 2;

            acc.setBalance(acc.getBalance() - money);
            return 3;
        } catch (Exception e) {
            System.out.println("Error during withdrawal: " + e.getMessage());
            return 1;
        }
    }

    @Override
    public boolean transferMoney(Account from, Account to, double money) {
        try {
            int fromIndex = checkIfAccountExists(from);
            int toIndex = checkIfAccountExists(to);

            if(fromIndex == toIndex){
                System.out.println("Error during transfer money");
                return false;
            }
            if (fromIndex == -1 || toIndex == -1) {
                System.out.println("One of the accounts does not exist.");
                return false;
            }

            Account fromAcc = eWallet.getAccounts().get(fromIndex);
            Account toAcc = eWallet.getAccounts().get(toIndex);

            if (fromAcc.getBalance() < money) {
                System.out.println("Insufficient balance.");
                return false;
            }

            fromAcc.setBalance(fromAcc.getBalance() - money);
            toAcc.setBalance(toAcc.getBalance() + money);

            System.out.println("Transfer successful.");
            return true;
        } catch (Exception e) {
            System.out.println("Error during transfer: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Account getAccountByUserName(Account account) {
        try {
            int accountIndex = checkIfAccountExists(account);
            if (accountIndex == -1) return null;
            return eWallet.getAccounts().get(accountIndex);
        } catch (Exception e) {
            System.out.println("Error getting account: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Account getAccountByUserName(String userName) {
        try {
            for (Account acc : eWallet.getAccounts()) {
                if (acc.getUserName().equals(userName)) {
                    return acc;
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving account by username: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void showAccountDetails(Account account) {
        try {
            if (Objects.isNull(account)) {
                System.out.println("Account does not exist to show profile details.");
                return;
            }
            System.out.println("-> userName:     " + account.getUserName());
            System.out.println("-> password:     " + account.getPassword());
            System.out.println("-> age:          " + account.getAge());
            System.out.println("-> phone number: " + account.getPhoneNumber());
            System.out.println("-> Balance:      " + account.getBalance());
        } catch (Exception e) {
            System.out.println("Error displaying account details: " + e.getMessage());
        }
    }

    @Override
    public boolean changePassword(Account account, String oldPassword, String newPassword) {
        try {
            int index = checkIfAccountExists(account);
            if (index == -1) {
                System.out.println("Account not found.");
                return false;
            }

            Account currentAccount = eWallet.getAccounts().get(index);
            if (!currentAccount.getPassword().equals(oldPassword)) {
                System.out.println("Old password is incorrect.");
                return false;
            }

            currentAccount.setPassword(newPassword);
            System.out.println("Password changed successfully.");
            return true;
        } catch (Exception e) {
            System.out.println("Error changing password: " + e.getMessage());
            return false;
        }
    }
}
