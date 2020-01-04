package StuentPackage;

public class StudentB extends Student {

    public StudentB(String sNo, int classNo, String name, char sex, int age) {
        super(sNo, classNo, name, sex, age);
    }

    @Override
    public String toString() {
        return "学号：" + super.getsNo() + ", 班号：" + super.getClassNo() + "班，姓名："
                + super.getName() + "，性别：" + super.getSex() + "，年龄：" + super.getAge() + "。";
    }
}
