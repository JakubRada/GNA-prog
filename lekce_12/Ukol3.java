package lekce_12;

import java.util.Arrays;
public class Ukol3 {
  public static int[] zvetsit(int[] staryList) {
    int[] novyList = new int[staryList.length + 1];
    for (int i = 0; i < staryList.length; i += 1) {
      novyList[i] = staryList[i];
    }
    return novyList;
  }
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int[] cisla = new int[0];
    int pocet = 0;
    int nejcetnejsi = 0;
    int cetnost = 1;
    int cetnostNejcetnejsiho = 0;
    int posledni = 0;
    while (sc.hasNextInt()) {
      cisla = zvetsit(cisla);
      cisla[pocet] = sc.nextInt();
      pocet += 1;
    }
    Arrays.sort(cisla);
    posledni = cisla[0];
    nejcetnejsi = cisla[0];
    cetnostNejcetnejsiho = 0;
    for (int i = 0; i < pocet; i += 1) {
         if (cisla[i] == posledni) {
          cetnost += 1;
          if (cetnost > cetnostNejcetnejsiho) {
            cetnostNejcetnejsiho = cetnost;
            nejcetnejsi = cisla[i];
          }
         } else {
           posledni = cisla[i];
           cetnost = 1;
         }
    }
    System.out.print(nejcetnejsi);
  }
}