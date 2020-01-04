package Forth_Date;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
        year = 2008;
        month = 1;
        day = 1;
    }

    public MyDate(int y, int m, int d) {
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void showDate() {
        System.out.println(year + "年" + month + "月" + day + "日");
    }

}
