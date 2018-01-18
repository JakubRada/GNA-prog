package lekce_3;

public class Podminky {
  public static void main(String args[]) {
    int a = Integer.parseInt(args[0]);
    if (a < 0) {
      System.out.print("A je zaporne");
    } else {
      System.out.print("A je nezaporne");
    }
  }
}