package lekce_10;

public class Kruh {
  public static void kresli(int polomer){
    for (int y = -polomer; y <= polomer; y += 1){
      for (int x = -polomer; x <= polomer; x += 1) {
        if ((x * x + y * y) <= polomer * polomer){
          System.out.print("X");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
  public static void main(String[] args){
    kresli(1);
    System.out.println();
    kresli(5);
    System.out.println();
    kresli(10);
  }
}