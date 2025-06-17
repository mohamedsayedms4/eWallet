package model;

// Account class representing a user's wallet account
public class Account {

    // Basic account attributes
    private String userName;
    private String password;
    private String phoneNumber;
    private double balance;
    private int age;
    private String email;
    private String address;
    private String nationalId;

    // Private constructor used by the builder
    private Account(AccountBuilder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.balance = builder.balance;
        this.age = builder.age;
        this.email = builder.email;
        this.address = builder.address;
        this.nationalId = builder.nationalId;
    }


    // Getters and setters for each attribute
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    // Static nested Builder class for Account
    public static class AccountBuilder {

        // Required and optional fields for building an account
        private String userName;
        private String password;
        private String phoneNumber;
        private double balance;
        private int age;
        private String email;
        private String address;
        private String nationalId;

        // Constructor with required fields userName - password - phoneNumber  - age for sign up
        public AccountBuilder(String userName, String password, String phoneNumber,  int age) {
            this.userName = userName;
            this.password = password;
            this.phoneNumber = phoneNumber;
            this.balance = 0;
            this.age = age;
        }

        // Constructor with required fields userName - password  for sign in
        public AccountBuilder(String userName, String password){
            this.userName = userName;
            this.password = password;
        }

        // Builder methods to set optional fields
        public AccountBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public AccountBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public AccountBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public AccountBuilder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public AccountBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public AccountBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public AccountBuilder setNationalId(String nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        // Final build method to create an Account instance
        public Account build() {
            return new Account(this);
        }
    }

    // Overridden toString method to print account info
    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", balance=" + balance +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nationalId='" + nationalId + '\'' +
                '}';
    }
}
