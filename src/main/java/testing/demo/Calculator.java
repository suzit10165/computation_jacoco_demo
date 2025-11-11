package testing.demo;

public class Calculator {

    public int add(int value1, int value2) {
        return value1 + value2;
    }

    public int substract(int value1, int value2) {
        return value1 - value2;
    }

    public int multiple(int value1, int value2) {
        return value1 * value2;
    }

    public int divide(int value1, int value2) {
        if (value2 == 0)
            throw new IllegalArgumentException("Denominator value cannot be zero.");
        return value1 / value2;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Addition: " + calc.add(10, 5));
        System.out.println("Subtraction: " + calc.substract(10, 5));
        System.out.println("Multiplication: " + calc.multiple(10, 5));
        System.out.println("Division: " + calc.divide(10, 5));
    }
}
