package StuentPackage;

public class Student {
    private String sNo;
    private int classNo;
    private String name;
    private char sex;
    private int age;

    public Student(String sNo, int classNo, String name, char sex, int age) {
        this.sNo = sNo;
        this.classNo = classNo;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public int getClassNo() {
        return classNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getsNo() {
        return sNo;
    }

    public char getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }
}