package lekce_6;

public class Prumer {
    public static void main(String[] args) {
        double suma = 0;
        int pocet = 0;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (sc.hasNextDouble()) {
            suma += sc.nextDouble();
            pocet++;
        }
        System.out.printf("Prumer je %2.2f.\n", suma / pocet);
    }
}
