package lekce_5;

public class Suma {
  public static void main(String[] args){
    double suma = 0;
    java.util.Scanner sc = new java.util.Scanner(System.in);
    while (sc.hasNextDouble()) {
      suma += sc.nextDouble();
    }
    System.out.printf("Soucet    %f.\n", suma);
  }
}