package eighth_Course;

public class Course {
    private String cNnumber;
    private String Cname;
    private int Cuit;

    public Course(String cNnumber, String cname, int cuit) {
        this.cNnumber = cNnumber;
        Cname = cname;
        Cuit = cuit;
    }

    public void printCourseInfo() {
        System.out.println("课程编号：" + cNnumber + "，课程名：" + Cname + "，学分数：" + Cuit);
    }

}
