package lekce_7;

public class Odmocnina {
    public static double SquareRoot (double number, double previousSquareRoot) {
        double nextSquareRoot = (previousSquareRoot + (number / previousSquareRoot)) / 2;
        return nextSquareRoot;
    }
    public static void main(String[] args) {
        double number = Double.parseDouble(args[0]);
        double oldResult = number;
        double newResult = 0;
        double difference = 1;
        while (difference > 0.0001) {
            newResult = SquareRoot(number, oldResult);
            difference = oldResult - newResult;
            oldResult = newResult;
        }
        System.out.printf("%.4f\n", newResult);
    }
}