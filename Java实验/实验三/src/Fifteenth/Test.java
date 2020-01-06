package Fifteenth;

import java.awt.*;
import java.util.Map;

class Pointer {
    private double x = 0.0;
    private double y = 0.0;

    public Pointer(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void display() {
        System.out.println("(" + x + "," + y + ")");
    }

    @Override
    public String toString() {
        return "Pointer{" + "x=" + x + ", y=" + y + '}';
    }

    public boolean equals(Pointer p) {
        double e = 0.000001;
        return (Math.abs(p.x - x) <= e) && (Math.abs(p.y - y) <= e);
    }

    public double distance(Pointer p) {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
}

public class Test {
    public static void main(String[] args) {
        Pointer p1 = new Pointer(5.0, 5.0);
        Pointer p2 = new Pointer(0.0, 0.0);

        System.out.println(p1.toString() +"，" + p2.toString() + "距离为：" + p1.distance(p2));
    }
}
