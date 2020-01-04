package Twentyforth;

public class Calendar {
    private int year;
    static int week = 0;

    public Calendar(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
