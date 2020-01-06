package Twelveth;

public class Faculty extends Employee {
    private MyDate officeTime;
    private int rank;

    public Faculty(String name, String address, String phone, String e_mail, String office, int salary, MyDate date_emplyeed, MyDate officeTime, int rank) {
        super(name, address, phone, e_mail, office, salary, date_emplyeed);
        this.officeTime = officeTime;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Faculty:" + super.name;
    }
}
