package lekce_3;

public class Nasobilka {
    public static void main(String args[]) {
        for (int i = 1; i <= 10; i += 1){
            for (int m = 1; m <= 10; m += 1){
                if (i * m >= 10){
                    System.out.printf("%d ", i * m);
                } else {
                    System.out.printf("%d  ", i * m);
                }
            }
            System.out.print("\n");
        }
    }
}