package Sixteenth;

class Vehlcles {
    int size;
    String color;
    int seats;
    public Vehlcles(int size,String color,int seats){
        this.size=size;
        this.color=color;
        this.seats=seats;
    }
    public void ShowMessages() {
        System.out.println("Vehlcles"+"尺寸:"+size+" 颜色:"+color+" 座位数:"+seats);
    }
}
class Car extends Vehlcles{
    public Car(int size,String color,int seats){
        super(size,color,seats);
    }
    public void ShowMessages() {
        System.out.println("Car"+"尺寸:"+super.size+" 颜色:"+super.color+" 座位数:"+super.seats);
    }
}
public class Test {
    public static void main(String[] args) {
        Car car=new Car(20,"黑",20);
        car.ShowMessages();
    }
}

