public class Test4 {
    public static int factorNum(int n) {
        int res = 1, sum = 0;
        for (int j  = 1; j <= n; j++) {
            for (int i = 2; i <= j; i++) {
                res *= i;
            }
            sum += res;
            res = 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int i;
        for (i = 2; factorNum(i) <= 99999; i++);
        System.out.println(i - 1);
    }
}
