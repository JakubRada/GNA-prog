package lekce_11;

public class Otoceni3 {
  public static void main(String args[]) {
    PoleIntu pole = new PoleIntu();
    java.util.Scanner sc = new java.util.Scanner(System.in);
    while (sc.hasNextInt()) {
      pole.pridej(sc.nextInt());
    }
    for (int i = pole.delka() - 1; i >= 0; i -= 1) {
      System.out.printf(" %d", pole.prvek(i));
    }
    System.out.println();
  }
}