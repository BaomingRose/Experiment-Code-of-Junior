package fourteenth;

class SA {
    public int f(int a, int b) {
        return a > b ? a : b;
    }
}

class SB extends SA{
    public int f(int a, int b) {
        int m = gcd(a, b);
        return a * b / m;
    }

    private int gcd(int a, int b) {
        int tmp;
        while(b != 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}

public class Test {
    public static void main(String[] args) {
        SA sa = new SA();
        System.out.println(sa.f(24, 36));
        SB sb = new SB();
        System.out.println(sb.f(24, 36));
    }
}
