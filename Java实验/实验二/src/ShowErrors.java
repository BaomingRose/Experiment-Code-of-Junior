import javafx.scene.shape.Circle;

class C {
    int value = 2;
}
public class ShowErrors {
    public void method1() {
        Circle c = new Circle();
        System.out.println("what is radius" + c.getRadius());
        //c = new Circle();
        C f = new C();
        System.out.println(f.value);
    }

}
