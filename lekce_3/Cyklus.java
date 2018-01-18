package lekce_3;

public class Cyklus {
  public static void main(String arg[]) {
    int j = 10;
    for (int i = 1; (i <= 10) || (j < 25); i += 1) {
      System.out.printf("%d %d\n", j, i * 2);
      j ++;
    }
  }
}