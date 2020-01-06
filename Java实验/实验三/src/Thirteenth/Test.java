package Thirteenth;

class A {
    public void f() {
        System.out.println("litter");
    }
}

class B extends A {
    public void g() {
        System.out.println("中文字符串");
    }
}

public class Test {
    public static void main(String[] args) {
        B b = new B();
        b.f();
        b.g();
    }
}
