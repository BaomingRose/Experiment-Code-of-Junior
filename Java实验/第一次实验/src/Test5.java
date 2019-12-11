public class Test5 {
    public static boolean narcissNum(int n) {
        int sum = 0;
        for (int i = n; i != 0; i /= 10) {
            sum += Math.pow(i % 10, 3);
        }
        return sum == n;
    }

    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            if (narcissNum(i)) {
                System.out.println(i + " ");
            }
        }
    }
}
