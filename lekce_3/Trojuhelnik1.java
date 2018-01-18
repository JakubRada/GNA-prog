package lekce_3;

public class Trojuhelnik1 {
    public static void main(String args[]) {
        int y = Integer.parseInt(args[0]);
        for (int i = 1; i <= y; i += 1) {
            for (int n = 1; n <= i; n += 1) {
                System.out.print("x");
            }
            System.out.print("\n");
        }
    }
}                                                                     