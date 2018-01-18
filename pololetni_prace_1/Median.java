package pololetni_prace_1;

import java.util.Arrays;

public class Median {
    public static int[] zvetsi_list(int[] stary_list) {
        int[] novy_list = new int[stary_list.length + 1];
        for (int i = 0; i < stary_list.length; i += 1) {
            novy_list[i] = stary_list[i];
        }
        return novy_list;
    }
    public static void main(String[] args) {
        int[] zadana_cisla = new int[1];
        int pocet = 0;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (sc.hasNextInt()) {
            if (pocet == zadana_cisla.length) {
                zadana_cisla = zvetsi_list(zadana_cisla);
            }
            zadana_cisla[pocet] = sc.nextInt();
            pocet += 1;
        }
        Arrays.sort(zadana_cisla);
        System.out.print("Median je: ");
        if (zadana_cisla.length % 2 != 0) {
            int median = zadana_cisla[(zadana_cisla.length - 1) / 2];
            System.out.printf("%d\n", median);
        } else {
            int median1 = zadana_cisla[(zadana_cisla.length - 1) / 2];
            int median2 = zadana_cisla[(zadana_cisla.length + 1) / 2];
            double prumer = (median1 + median2) / 2;
            System.out.printf("%.1f (%d a %d, pokud nechceme prumer)\n", prumer, median1, median2);
        }
    }
}