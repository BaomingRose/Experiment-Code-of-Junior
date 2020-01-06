package Twelveth;

public class Person {
    protected String name;
    protected String address;
    protected String phone;
    protected String e_mail;

    public Person(String name, String address, String phone, String e_mail) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.e_mail = e_mail;
    }

    @Override
    public String toString() {
        return "Person:" + name;
    }
}
