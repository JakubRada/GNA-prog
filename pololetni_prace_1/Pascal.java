package pololetni_prace_1;

public class Pascal {
    public static int[] novy_radek(int[] stary_radek) {
        int[] novy_radek = new int[stary_radek.length + 1];
        for (int i = 1; i < novy_radek.length - 1; i += 1) {
            novy_radek[i] = stary_radek[i - 1] + stary_radek[i];
        }
        return novy_radek;
    }
    public static void tisk(int[] list, int pocet_mezer){
        for (int n = 0; n <= pocet_mezer; n += 1) {
            System.out.print(" ");
        }
        for (int n = 1; n < list.length - 1; n += 1) {
            System.out.printf("%4d", list[n]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int pocet_radku = Integer.parseInt(args[0]);
        int[] radek = new int[] {0, 1, 0};
        for (int i = 0; i < pocet_radku; i += 1) {
            int pocet_mezer_pred_radkem = (pocet_radku - 1 - i) * 2;
            tisk(radek, pocet_mezer_pred_radkem);
            radek = novy_radek(radek);            
        }
    }
}