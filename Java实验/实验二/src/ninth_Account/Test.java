package ninth_Account;

public class Test {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000, 0.045, "2018-01-01");
        account.withDraw(2500);
        account.deposit(3000);
        System.out.println("该账户余额为：");
        System.out.println(account.getBalance());
        System.out.println("月利率为：");
        System.out.println(account.getMonthlyInterestRate());
        System.out.println("该账户开户日期为：");
        System.out.println(account.getDateCreated());

    }
}
