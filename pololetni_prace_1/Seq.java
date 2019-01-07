package pololetni_prace_1;

public class Seq {
    public static void tisk(int zacatek, int konec, int krok, String mezera) { // funkce, ktera tiskne cisal a mezery, podle argumentu
        if (krok != 0) {
            if (zacatek < konec) {
                for (int i = zacatek; i <= konec; i += krok) {
                    if (i + krok <= konec) {
                        System.out.printf("%d%s", i, mezera);
                    } else {
                        System.out.printf("%d", i);
                    }
                }
            } else if ((zacatek > konec) && (krok < 0)) {
                for (int i = zacatek; i >= konec; i += krok) {
                    if (i + krok >= konec) {
                        System.out.printf("%d%s", i, mezera);
                    } else {
                        System.out.printf("%d", i);
                    }
                }
            } 
        }
    }
    public static boolean jeCislo(String promena) { // overeni, zda je input mozne premenit na cislo, nebo ne
        try {
            Integer.parseInt(promena);
            return true;
        } catch (NumberFormatException ex2) {
            return false;
        }
    }
    public static String[] filtr(String[] puvodniList) { // odstraneni prazdnych stringu -> kdyz je mene inputu nez maximalni rozsah 5
        int pocet = 0;
        for (int i = 0; i < puvodniList.length; i += 1) {
            if (puvodniList[i] != "") {
                pocet += 1;
            }
        }
        String[] filtrovanyList = new String[pocet];
        for (int i = 0; i < pocet; i += 1) {
            filtrovanyList[i] = puvodniList[i];
        }
        return filtrovanyList;
    }
    public static void typyTisku(int[] ciselnyList, String mezera) { // urceuje, jake parametry bude mit funkce tisk zadane
        if (ciselnyList.length == 1) {
            tisk(1, ciselnyList[0], 1, mezera);
        } else if (ciselnyList.length == 2) {
            tisk(ciselnyList[0], ciselnyList[1], 1, mezera);
        } else if (ciselnyList.length == 3) {
            tisk(ciselnyList[0], ciselnyList[2], ciselnyList[1], mezera);
        }
    }
    public static void main(String[] args) {
        // vstup vsech moznych argumentu - kdyz zadny neni, vlozi se prazdny String
        String[] argumenty = new String[5];
        for (int i = 0; i < argumenty.length; i += 1) {
            try {
                argumenty[i] = args[i];
            } catch (ArrayIndexOutOfBoundsException ex1) {
                argumenty[i] = "";
            }
        }
        // vyfiltrovani prazdnych mist z listu
        argumenty = filtr(argumenty);
        // dve podminky (jestli je to moznost '-s' nebo normalni ciselna moznost)
        if ((argumenty[0].equals("-s")) && (argumenty.length > 2)) {
            try {
                int[] ciselneArgumenty = new int[argumenty.length - 2];
                for (int i = 0; i < ciselneArgumenty.length; i += 1) {
                    ciselneArgumenty[i] = Integer.parseInt(argumenty[i + 2]);
                }
                typyTisku(ciselneArgumenty, argumenty[1]);
            } catch (NumberFormatException ex2) {}
        } else if (jeCislo(argumenty[0])) {
            try {
                int[] ciselneArgumenty = new int[argumenty.length];
                for (int i = 0; i < ciselneArgumenty.length; i += 1) {
                    ciselneArgumenty[i] = Integer.parseInt(argumenty[i]);
                }
                typyTisku(ciselneArgumenty, " ");
            } catch (NumberFormatException ex2) {}
        }
    }
}