package Seventeenth;

class MyRectangle{
    double width;
    double height;
    public double getArea() {
        return width*height;
    }
    public void showInfo() {
        System.out.println("矩形"+"宽度:"+width+"\t长度:"+height);
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

}
class MySquare extends MyRectangle{
    public double getArea() {
        return super.width*super.height;
    }
    public void showInfo() {
        System.out.println("正方形"+"宽度:"+ super.width+"\t长度:"+ super.height);
    }
}
public class Test {
    public static void main(String[] args) {
        MyRectangle myRectangle=new MyRectangle();
        myRectangle.setHeight(5);
        myRectangle.setWidth(4);
        System.out.println(myRectangle.getArea());
        myRectangle.showInfo();
        MySquare mySquare=new MySquare();
        mySquare.setHeight(3);
        mySquare.setWidth(3);
        System.out.println(mySquare.getArea());
        mySquare.showInfo();
    }
}

