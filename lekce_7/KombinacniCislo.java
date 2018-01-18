package lekce_7;

public class KombinacniCislo {
    public static int factorial(int number) {
        int result = 1;
        for (int i = number; i > 1; i -= 1) {
            result *= i;
        }
        return result;
    }
    public static boolean IsNotNegative(int n, int k) {
        return ((k >= 0) && (n >= k));
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        if (IsNotNegative(n, k)) {
            if (n < 13) {
                int result = factorial(n) / (factorial(k) * factorial(n - k));
                System.out.println(result);
            } else {
                System.out.println("Pro n > 12 vyjde spatny vysledek");
            }
        } else {
            System.out.println("Byla zadana neplatna cisla");
        }
    }
}