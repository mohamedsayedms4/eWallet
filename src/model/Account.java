package model;

public class Account {
    // User details
    private String userName;
    private String password;
    private String fullNumber;
    private double balance;
    private int age;

    // Full constructor
    public Account(String userName, String password, String fullNumber, int age) {
        this.userName = userName;
        this.password = password;
        this.fullNumber = fullNumber;
        this.age = age;
        this.balance = 0;
    }

    // Minimal constructor (used for login)
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Getters and setters

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

    public String getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber(String fullNumber) {
        this.fullNumber = fullNumber;
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

    // toString override for debugging or printing

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fullNumber='" + fullNumber + '\'' +
                ", balance=" + balance +
                ", age=" + age +
                '}';
    }
}
