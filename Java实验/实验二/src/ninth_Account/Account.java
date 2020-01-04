package ninth_Account;

public class Account {
    private int ID;
    private double balance;
    private double annualInterestRate;
    private String dateCreated;

    public Account() {
        this.ID = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = "2000-01-01";
    }

    public Account(int ID, double balance, double annualInterestRate, String dateCreated) {
        this.ID = ID;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = dateCreated;
    }

    public int getID() {
        return ID;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 12;
    }

    public void withDraw(double getMoney) {
        if (balance - getMoney >= 0) {
            this.balance -= getMoney;
        }
    }

    public void deposit(double saveMoney) {
        this.balance += saveMoney;
    }

}


