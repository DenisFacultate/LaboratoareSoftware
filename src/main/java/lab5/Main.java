package lab5;

public class Main {
    public static void main(String[] args) {
        AdvancedCalculator calculator = new AdvancedCalculator(10);
        int result = calculator.add(5).substract(3).multiply(2).pow(2).result();
        System.out.println("a) " + result);
    }
}
