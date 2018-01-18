package pololetni_prace_1;

public class Scitani {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        java.util.Random nahoda = new java.util.Random();
        for (int i = 0; i < 10; i += 1) {
            a = nahoda.nextInt(21);
            b = nahoda.nextInt(21 - a);
            System.out.printf("%d + %d = %d\n", a, b, a + b);
        }
    }
}