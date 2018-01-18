package lekce_12;

public class Ukol4 {
  public static boolean isPrime(int cislo) {
      boolean jePrvocislo = true;
        if (cislo <= 1) {
            jePrvocislo = false;
        } else {
            int delitel = 2;
            while (delitel * delitel <= cislo) {
                if ((cislo % delitel) == 0) {
                    jePrvocislo = false;
                }
                delitel++;
            }
        }
        return jePrvocislo;
  }
  public static void main(String[] args) {
    int min = Integer.parseInt(args[0]);
    int max = Integer.parseInt(args[1]);
    int pocet = 0;
    for (int i = min; i <= max; i += 1) {
      if (isPrime(i)) {
        pocet += 1;
      } 
    }
    System.out.print(pocet);
  }
}