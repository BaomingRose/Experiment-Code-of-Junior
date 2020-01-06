package Twelveth;

public class Employee extends Person {
    protected String office;
    protected int salary;
    protected MyDate date_emplyeed;

    public Employee(String name, String address, String phone, String e_mail, String office, int salary, MyDate date_emplyeed) {
        super(name, address, phone, e_mail);
        this.office = office;
        this.salary = salary;
        this.date_emplyeed = date_emplyeed;
    }

    @Override
    public String toString() {
        return "Employee:" + super.name;
    }
}
