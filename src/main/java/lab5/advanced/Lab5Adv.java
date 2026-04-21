package lab5.advanced;

public class Lab5Adv {
    public static void main(String[] args) {
        NewIntCalculator intCalc = new NewIntCalculator();
        intCalc.init(10);
        int intRes = (Integer) intCalc.add(5).substract(3).multiply(2).result();
        System.out.println("Rezultat Integer: (10 + 5 - 3) * 2 = " + intRes);

        DoubleCalculator doubleCalc = new DoubleCalculator();
        doubleCalc.init(10.0);
        double doubleRes = (Double) doubleCalc.add(5.0).substract(3.3).multiply(2.2).result();
        System.out.printf("Rezultat Double: (10 + 5 - 3.3) * 2.2 = %.2f\n", doubleRes);
    }
}