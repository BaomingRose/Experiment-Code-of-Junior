package Twelveth;

public class Staff extends Employee {
    private String title;

    public Staff(String name, String address, String phone, String e_mail, String office, int salary, MyDate date_emplyeed, String title) {
        super(name, address, phone, e_mail, office, salary, date_emplyeed);
        this.title = title;
    }

    @Override
    public String toString() {
        return "Staff:" + super.name;
    }
}
