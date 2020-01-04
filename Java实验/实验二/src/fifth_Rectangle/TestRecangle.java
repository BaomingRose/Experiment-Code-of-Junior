package fifth_Rectangle;

public class TestRecangle {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4.0, 40, "黄色");
        Rectangle rectangle2 = new Rectangle(3.5, 35.9, "红色");

        System.out.println("rectangle1:" + "宽：" + rectangle1.getWidth() + "，高：" + rectangle1.getHeight() + "，颜色：" + rectangle1.getColor() + "，面积：" + rectangle1.getArea() + "，周长：" + rectangle1.getPerimeter());
        System.out.println("rectangle2:" + "宽：" + rectangle2.getWidth() + "，高：" + rectangle2.getHeight() + "，颜色：" + rectangle2.getColor() + "，面积：" + rectangle2.getArea() + "，周长：" + rectangle2.getPerimeter());
    }
}
