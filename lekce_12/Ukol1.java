package lekce_12;

public class Ukol1 {
  public static void main(String[] args) {
    int poradi = Integer.parseInt(args[0]);
    int cislo = 0;
    java.util.Scanner sc = new java.util.Scanner(System.in);
    for(int i = 0; i < poradi; i += 1) {
      cislo = sc.nextInt();             
    }
    System.out.print(cislo);
  }
}