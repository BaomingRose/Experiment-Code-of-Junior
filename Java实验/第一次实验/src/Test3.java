public class Test3 {
    public static boolean isPerfectNum(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 1000; i++) {
            if (isPerfectNum(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
