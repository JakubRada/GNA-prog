package lekce_11;

public class CetnostCisel {
    public static void main(String[] args) {
        Cetnosti seznam = new Cetnosti();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (scanner.hasNextInt()) {
            seznam.zapocitej(scanner.nextInt());
        }
        for (int i = 0; i < seznam.seznamCisel().length; i += 1) {
            System.out.printf("Cislo %d ... %dx\n", seznam.seznamCisel()[i], seznam.cetnost(seznam.seznamCisel()[i]));
        }
    }
}