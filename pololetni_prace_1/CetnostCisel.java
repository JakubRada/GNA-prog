package pololetni_prace_1;

public class CetnostCisel {
    public static int[] zvetsi_list(int[] stary_list) {
        int[] novy_list = new int[stary_list.length + 1];
        for (int i = 0; i < stary_list.length; i += 1) {
            novy_list[i] = stary_list[i];
        }
        return novy_list;
    }
    public static void tisk(int[] list1, int[] list2, int pocet) {
        for (int i = 0; i < pocet; i += 1) {
            System.out.printf("%d ... %d\n", list1[i], list2[i]);
        }
        System.out.println();
    }
    public static boolean je_v_listu(int[] list, int cislo) {
        for (int i = 0; i < list.length; i += 1) {
            if (list[i] == cislo) {
                return true;
            }
        }
        return false;
    }
    public static void tisk_serazenych_listu(int[] hlavni_list, int[] vedlejsi_list, int pocet, String razeni) {
        int[] serazeny_hlavni_list = new int[pocet];
        int[] serazeny_vedlejsi_list = new int[pocet];
        int index = 0;
        for (int i = 0; i < pocet; i += 1) {
            for (int n = 0; n < pocet; n += 1) {
                if (i != n) {
                    if (razeni == "velikost"){
                        if (hlavni_list[i] > hlavni_list[n]) {
                            index += 1;
                        } else if ((hlavni_list[i] == hlavni_list[n]) && (vedlejsi_list[i] > vedlejsi_list[n])) {
                            index += 1;
                        }
                    } else {
                        if (hlavni_list[i] < hlavni_list[n]) {
                            index += 1;
                        } else if ((hlavni_list[i] == hlavni_list[n]) && (vedlejsi_list[i] < vedlejsi_list[n])) {
                            index += 1;
                        }
                    }
                }
            }
            serazeny_hlavni_list[index] = hlavni_list[i];
            serazeny_vedlejsi_list[index] = vedlejsi_list[i];
            index = 0;
        }
        if (razeni == "velikost") {
            tisk(serazeny_hlavni_list, serazeny_vedlejsi_list, pocet);
        } else {
            tisk(serazeny_vedlejsi_list, serazeny_hlavni_list, pocet);
        }
    }
    public static void main(String[] args) {
        int[] input_cisel = new int[0];
        int[] cetnosti = new int[0];
        int pocet = 0;
        int aktualni_cislo = 0;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (sc.hasNextInt()) {
            aktualni_cislo = sc.nextInt();
            if (je_v_listu(input_cisel, aktualni_cislo)) {
                for (int i = 0; i < pocet; i += 1) {
                    if (aktualni_cislo == input_cisel[i]) {
                        cetnosti[i] += 1;
                        break;
                    }
                }
            } else {
                input_cisel = zvetsi_list(input_cisel);
                cetnosti = zvetsi_list(cetnosti);
                input_cisel[pocet] = aktualni_cislo;
                cetnosti[pocet] = 1;
                pocet += 1;
            }
        }
        System.out.println("Cisla serazena podle velikosti");
        tisk_serazenych_listu(input_cisel, cetnosti, pocet, "velikost");
        System.out.println("Cisla serazena podle cetnosti");
        tisk_serazenych_listu(cetnosti, input_cisel, pocet, "cetnost");
    }
}
