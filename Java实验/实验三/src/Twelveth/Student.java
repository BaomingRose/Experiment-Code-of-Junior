package Twelveth;

public class Student extends Person {
    private int grade;

    public Student(String name, String address, String phone, String e_mail, int grade) {
        super(name, address, phone, e_mail);
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student:" + super.name;
    }
}
