import model.Account;
import model.EWallet;
import service.ApplicationService;
import service.ApplicationServiceImp;

public class Main {
    public static void main(String[] args) {
        // Create singleton EWallet instance
        EWallet eWallet = EWallet.getInstance();

        // Add some predefined test accounts
        Account account = new Account("mo", "123", "15", 1);
        Account account1 = new Account("ahmed", "123", "15", 1);
        Account account2 = new Account("sayed", "123", "15", 1);

        eWallet.getAccounts().add(account);
        eWallet.getAccounts().add(account1);
        eWallet.getAccounts().add(account2);

        // Start application flow
        ApplicationService app = new ApplicationServiceImp();
        app.start();
    }
}
