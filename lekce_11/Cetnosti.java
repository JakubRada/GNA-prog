package lekce_11;

public class Cetnosti {
    int[] cetnosti = new int[0];
    int[] cisla = new int[0];
    public Cetnosti() {}
    public void zapocitej(int cislo) {
        int jeVListu = 0;
        for (int i = 0; i < cisla.length; i += 1) {
            if (cislo == cisla[i]) {
                cetnosti[i] += 1;
                jeVListu = 1;
                break;
            } else {
                continue;
            }
        }
        if (jeVListu == 0) {
            int[] cislaTmp = new int[cisla.length + 1];
            int[] cetnostiTmp = new int[cetnosti.length + 1];
            for (int n = 0; n < cisla.length; n += 1) {
                cislaTmp[n] = cisla[n];
                cetnostiTmp[n] = cetnosti[n];
            }
            cisla = cislaTmp;
            cetnosti = cetnostiTmp;
            cisla[cisla.length - 1] = cislo;
            cetnosti[cisla.length - 1] = 1;
        }
    }
    public int[] seznamCisel() {
        return cisla;
    }
    public int cetnost(int cislo) {
        int pocet = 0;
        for (int i = 0; i < cisla.length; i += 1) {
            if (cislo == cisla[i]) {
                break;
            } else {
                pocet += 1;
            }
        }
        return cetnosti[pocet];
    }
}