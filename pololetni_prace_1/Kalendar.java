//package pololetni_prace_1;

import java.util.Calendar;

public class Kalendar {
    public static void tiskKalendaru(int rok, int mesic) {
        KalGen kal = new KalGen(rok, mesic);
        kal.vytvorit();
        int rok1 = rok;
        int rok2 = rok;
        int mesic1 = mesic - 1;
        int mesic2 = mesic + 1;
        if (mesic == 11) {
            mesic1 = mesic - 1;
            mesic2 = 0;
            rok2 = rok + 1;
        } else if (mesic == 0) {
            mesic1 = 11;
            mesic2 = mesic + 1;
            rok1 = rok - 1;
        }
        KalGen kalPredchozi = new KalGen(rok1, mesic1);
        KalGen kalNasledujici = new KalGen(rok2, mesic2);
        kalPredchozi.vytvorit();
        kalNasledujici.vytvorit();
        for (int i = 0; i <= 10; i += 1) {
            kalPredchozi.tiskRadku(i);
            System.out.print(" ");
            kal.tiskRadku(i);
            System.out.print(" ");
            kalNasledujici.tiskRadku(i);
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        int aktualniMesic = c.get(Calendar.MONTH);
        int aktualniRok = c.get(Calendar.YEAR);
        try {
            int prvniArgument = Integer.parseInt(args[0]) - 1;
            if ((prvniArgument >= 0) && (prvniArgument <= 11)) {
                try {
                    int druhyArgument = Integer.parseInt(args[1]);
                    tiskKalendaru(druhyArgument, prvniArgument);
                } catch(ArrayIndexOutOfBoundsException ex1) {
                    tiskKalendaru(aktualniRok, prvniArgument);
                }
            }
        } catch(ArrayIndexOutOfBoundsException ex1) {
            tiskKalendaru(aktualniRok, aktualniMesic);
        }
    }
}