package lekce_14;

import java.util.Scanner;

public class Graf{
    public static void uvodSvg(int pocet, int limit) {
        System.out.println("<?xml version=\"1.0\"?>");
        System.out.println("<svg xmlns=\"http://www.w3.org/2000/svg\"");
        System.out.printf("width=\"%d\" height=\"%d\" viewBox=\"0 0 %d %d\">\n",
                pocet * 30 + 10, limit + 20,
                pocet * 30 + 10, limit + 20);
    }
    public static void main(String[] args) {
        int typ = Integer.parseInt(args[0]);
        int[] hodnoty = new int[100];
        int svgLimit = 200;
        int obrLimit = 60;
        int pocetHodnot = 0;
        int max = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int cislo = sc.nextInt();
            if (cislo < 0) {
                continue;
            }
            hodnoty[pocetHodnot] = cislo;
            if (cislo > max) {
                max = cislo;
            }
            pocetHodnot += 1;
            if (pocetHodnot == hodnoty.length) {
                break;
            }
        }
        if (typ == 0) {
            KreslicGrafu kresli = new ObrazovkovyGraf(max, obrLimit);
        } else if (typ == 1) {
            uvodSvg(pocetHodnot, svgLimit);
            KreslicGrafu kresli = new SvgGraf(max, svgLimit);
        }
        for (int i = 0; i < pocetHodnot; i += 1) {
            kresli.polozka(hodnoty[i], i);
        }
        if (typ == 1) {
            System.out.println("</svg>");
        }
    }
}