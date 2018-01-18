package lekce_12;

public class Ukol2 {
  public static void main(String[] args) {
    int max = Integer.parseInt(args[0]);
    int vysledek = 0;
    for (int i = 1; i * i < max; i += 1) {
       vysledek += i * i;
    }
    System.out.print(vysledek);
  }
}