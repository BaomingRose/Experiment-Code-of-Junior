package sixth_MyInteger;

public class MyInteger {
    private int i;

    public MyInteger(int x) {
        this.i = x;
    }

    public int getInt() {
        return i;
    }

    public boolean isEven() {
        if (this.i % 2 == 0)
            return true;
        return false;
    }

    public boolean isOdd() {
        if (this.i % 2 != 0)
            return true;
        return false;
    }

    public boolean isPrime() {
        for (int j = 2; j <= Math.sqrt(this.i); ++j) {
            if (this.i % j == 0)
                return false;
        }
        return true;
    }

    public boolean equals(int x) {
        if (this.i == x)
            return true;
        else
            return false;
    }

    public static int parseInt(String x) {
        int res = 0;
        for (int j = 0; j < x.length(); ++j) {
            res = res * 10 + (x.charAt(j) - '0');
        }
        return res;
    }
}
