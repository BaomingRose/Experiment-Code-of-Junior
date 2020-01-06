package First;

public class Student extends Person {
    private String id;
    private String cname;
    private int score;

    public Student(String name, char gender, int age, String id, String cname, int score) {
        super(name, gender, age);
        this.id = id;
        this.cname = cname;
        this.score = score;
    }
    public void display() {
        System.out.println("name:" + super.name);
        System.out.println("gender:" + super.gender);
        System.out.println("age:" + super.age);
        System.out.println("id:" + this.id);
        System.out.println("cname:" + this.cname);
        System.out.println("score:" + this.score);
    }

    public static void main(String[] args) {
        Student s = new Student("郭玉明", '男', 21, "201706010710", "计算机173", 100);
        s.display();
    }
}
