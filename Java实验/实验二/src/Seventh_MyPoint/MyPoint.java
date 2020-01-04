package Seventh_MyPoint;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(MyPoint a) {
        double dX = Math.abs(this.x - a.x);
        double dY = Math.abs(this.y - a.y);
        return Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
    }
}
