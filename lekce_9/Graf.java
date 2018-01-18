package lekce_9;

public class Graf {
  public static void tisk (int znaky) {
     for (int n = 0; n < znaky; n += 1) {
        System.out.print("#");
      }
      System.out.print("\n"); 
  }
  public static void main(String[] args) {
    System.out.println("Zadejte maximalne 100 kladnych cisel: ");
    int cisla[] = new int[100];
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int pocet = 0;
    int input = 0;
    int max = 0;
    int znaky = 0;
    while (sc.hasNextInt() && (pocet < cisla.length)) {
      input = sc.nextInt();
      if (input > 0) {
        cisla[pocet] = input;
        pocet += 1;
      }
      if (input > max) {
        max = input;
      }
    }
    if (max <= 60) {
      for (int i = 0; i < pocet; i += 1) {
         znaky = cisla[i];
         tisk(znaky);
      }
    } else {
      for (int i = 0; i < pocet; i += 1) {
          znaky = (int)((double)(cisla[i] * 60 / max) + 0.5);
          tisk(znaky);
      }
    } 
  }
}      