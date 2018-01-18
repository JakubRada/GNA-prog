package pololetni_prace_1;

import java.util.Calendar;

public class KalGen{
    int rok;
    int mesic;
    int[] dlouhe = new int[] {1, 3, 5, 7, 8, 10, 12};
    String[] mesiceNazvy = new String[] {"leden", "unor", "brezen", "duben", "kveten", "cerven", "cervenec", "srpen", "zari", "rijen", "listopad", "prosinec"};
    String[] text = new String[11];
    public KalGen(int r, int m){
        rok = r;
        mesic = m;
    }
    public String mezera(int delka) {
        String mezera = "";
        for(int i = 0; i < delka; i += 1) {
            mezera += " ";
        }
        return mezera;
    }
    public boolean jePrestupny() {
        if (rok % 4 == 0) {
            if (rok % 100 == 0) {
                if (rok % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public boolean jeVListu(int cislo, int[] list) {
        for (int i = 0; i < list.length; i += 1) {
            if ((cislo + 1) == list[i]) {
                return true;
            }
        }
        return false;
    }
    public int pocetDni() {
        if (jeVListu(mesic, dlouhe)) {
            return 31;
        } else if (mesic == 1) {
            if (jePrestupny()) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return 30;
        }
    }
    public int prvniDenMesice() {
        Calendar c = Calendar.getInstance();
        c.set(rok, mesic, 1);
        int denVTydnu = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (denVTydnu == 0) {
            denVTydnu = 7;
        }
        return denVTydnu;
    } 
    public void vytvorit() {
        text[0] = "+----------------------+";
        text[1] = "| " + mesiceNazvy[mesic] + " " + Integer.toString(rok) + mezera(16 - mesiceNazvy[mesic].length()) + "|";
        text[2] = text[0];
        text[3] = "| Po Ut St Ct Pa So Ne |";
        text[10] = text[0];
        int start = prvniDenMesice();
        int den = 1 - (start - 1);
        int pocet = pocetDni();
        for (int i = 4; i <= 9; i += 1) {
            text[i] = "| ";
            for (int n = 0; n < 7; n += 1) {
                if ((den < 1) || (den > pocet)) {
                    text[i] += "   ";
                } else {
                    text[i] += String.format("%2d ", den);
                }
                den += 1;
            }
            text[i] += "|";
        }
    }
    public void tiskRadku(int index) {
        System.out.print(text[index]);
    }
}