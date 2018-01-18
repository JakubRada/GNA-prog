package lekce_3;

public class Nasobky {
  public static void main(String args[]) {
    int a = Integer.parseInt(args[0]);  //nasobky cisla a
    int b = Integer.parseInt(args[1]);  //po kolika na radek
    for (int i = 0; i <= 10; i += 1){
      if ((i % b) == 0) {
        System.out.printf("\n%d ", i * a);
      } else {
        System.out.printf("%d ", i * a);
      }
    }
  }
}