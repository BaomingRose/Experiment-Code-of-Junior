package Seventh_MyPoint;

public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(1.0, 1.0);
        MyPoint point2 = new MyPoint();
        System.out.println(point1.distance(point2));
    }
}
