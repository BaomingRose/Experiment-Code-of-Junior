
class A {
    String s;
    A(String s) {
        this.s = s;
    }
    public void print() {
        System.out.println(s);
    }
}

class TestA {
    public static void main(String[] args) {
        A a = new A("d ");
        a.print();
    }
}
