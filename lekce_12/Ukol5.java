package lekce_12;

public class Ukol5 {
  public static void main(String[] args) {
    int max = Integer.parseInt(args[0]);
    int vysledek = 0;
    for (int i = 3; i * i < max; i += 3) {
      vysledek += i * i; 
    }
    System.out.print(vysledek);
  }
}