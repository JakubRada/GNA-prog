package lekce_3;

public class Delitele{
  public static void main(String args[]){
    int x = Integer.parseInt(args[0]);
    System.out.printf("Cislo %d je delitelne: \n", x);
    for (int i = 1; i <= x; i += 1){
      if (x % i == 0){
        System.out.println(i);
      }
    }
  }
}