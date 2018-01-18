package lekce_5;

public class Maximum {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        if (sc.hasNextInt()) {
            int x = sc.nextInt();
            int a = x;
            while (sc.hasNextInt()){
                x = sc.nextInt();
                if (x > a) {
                    a = x;
                }
            }
            System.out.printf("The highest number is %d.\n", a);
        } else {
            System.out.println("You have not entered any number.");
        }
    }
}