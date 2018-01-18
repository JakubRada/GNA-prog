package lekce_3;

public class Sude {
  public static void main(String args[]) {
    int a = Integer.parseInt(args[0]);
    if (a % 2 == 1) {
      System.out.print("Liche");
    } else {
      System.out.print("Sude");
    }
  }
}