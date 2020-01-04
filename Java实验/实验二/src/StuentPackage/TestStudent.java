package StuentPackage;

public class TestStudent {
    public static void main(String[] args) {
        Student stu = new Student("111111", 1, "欧阳翠芬", '男', 20);
        stu.setAge(30);
        System.out.println(stu.getAge());
    }
}
