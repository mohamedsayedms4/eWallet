    package model;

    import java.util.ArrayList;
    import java.util.List;

    public class EWallet {
        private final String name= "VODAFONE";
        private static EWallet instance;

        private List<Account> accounts = new ArrayList<>();

        private EWallet() {
        }

        public String getName() {
            return name;
        }

        public List<Account> getAccounts() {
            return accounts;
        }

        public void setAccounts(List<Account> accounts) {
            this.accounts = accounts;
        }
        public static EWallet getInstance() {
            if (instance == null) {
                instance = new EWallet();
            }
            return instance;
        }
    }
