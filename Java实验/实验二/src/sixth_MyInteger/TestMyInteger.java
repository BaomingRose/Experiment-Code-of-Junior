package sixth_MyInteger;

public class TestMyInteger {
    public static void main(String[] args) {
        MyInteger myInt = new MyInteger(100);
        System.out.println("myInt是否为奇数：" + myInt.isOdd());
        System.out.println("myInt是否为偶数：" + myInt.isEven());
        System.out.println("myInt是否为素数：" + myInt.isPrime());
        System.out.println("myInt和10000是否为相等：" + myInt.equals(1000));
        System.out.println("将字符串转为int：" + MyInteger.parseInt("123"));
    }
}
