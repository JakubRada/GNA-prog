package lekce_5;

public class Statistika {
    public static void main(String[] args) {
        double sum = 0;
        int pocet = 0;
        double sum_kvadr = 0;
        java.util.Scanner number = new java.util.Scanner(System.in);
        if (number.hasNextDouble()) {
            double first_double = number.nextDouble();
            double min = first_double;
            double max = first_double;
            pocet += 1;
            sum += first_double;
            sum_kvadr += (first_double * first_double);
            while (number.hasNextDouble()) {
                double x = number.nextDouble();
                sum += x;
                sum_kvadr += (x * x);
                pocet += 1;
                if (x > max + 0.00001) {
                    max = x;
                }
                if (x < min - 0.00001) {
                    min = x;
                }
            }
            double aritm_prumer = sum / pocet;
            double odchylka = Math.sqrt((sum_kvadr / pocet) - (aritm_prumer * aritm_prumer));
            System.out.printf("Soucet ... %.3f\nMaximum ... %.3f\nMinimum ... %.3f\nAritmeticky prumer ... %.3f\nSmerodatna odchylka ... %.3f\n", sum, max, min, aritm_prumer, odchylka);
        } else {
            System.out.println("Nebyla zadana zadna cisla.");
        }
    }
}
