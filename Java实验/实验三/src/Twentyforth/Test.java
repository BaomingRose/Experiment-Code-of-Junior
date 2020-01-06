package Twentyforth;

class Temperature {
    private int fahrenheit;//华氏温度
    private int celsius;//摄氏温度

    public int getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(int fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public int getCelsius() {
        return celsius;
    }

    public void setCelsius(int celsius) {
        this.celsius = celsius;
    }
}
public class Test {
    public static void main(String[] args) {
        Temperature temperature=new Temperature();
        temperature.setCelsius(36);
        temperature.setFahrenheit(0);
        System.out.println("摄氏温度："+temperature.getCelsius());
        System.out.println("华氏温度："+temperature.getFahrenheit());
    }
}

