package lekce_5;

public class Prvocislo {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int a = 0;
        if (x > 0) {
            for (int i = (x - 1); i > 1; i -= 1) {
                if ((x % i) == 0) {
                    a = 1;
                    break;
                }
            }
            if (a == 1){
                System.out.println("Neni to prvocislo");
            } else {
                System.out.println("Je to prvocislo");
            }
        } else {
            System.out.println("Neni to prvocislo");
        }
    }
}