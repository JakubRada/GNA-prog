package pololetni_prace_1;

public class Odmocnina {
    public static double treti_odmocnina(double stary_vysledek, int zaklad) {
        double novy_vysledek = ((zaklad / (stary_vysledek * stary_vysledek) + 2 * stary_vysledek) / 3);
        return novy_vysledek;
    }
    public static void main(String[] args) {
        int zaklad = Integer.parseInt(args[0]);
        double stary_vysledek = zaklad;
        double novy_vysledek = 0;
        double rozdil = 1;
        while (rozdil > 0.00001) {
            novy_vysledek = treti_odmocnina(stary_vysledek, zaklad);
            rozdil = stary_vysledek - novy_vysledek;
            stary_vysledek = novy_vysledek;
        }
        System.out.printf("Treti odmocnina cisla %d je: %.5f\n", zaklad, novy_vysledek);
    }
}