package lekce_3;

public class Trojuhelnik2 {
    public static void main(String args[]){
        int y = Integer.parseInt(args[0]);
        for (int i = 1; i <= y; i += 1){
            for (int n = (y - 1) - i; n >= 0; n -= 1){
                System.out.print(" ");
            }
            for (int m = (y + 1) - i; m <= y; m += 1){
                System.out.print("X");
            }
            System.out.print("\n");
        }
    }
}