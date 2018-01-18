package lekce_12;

public class Ukol6 {
  public static void main(String[] args) {
    String abeceda = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    char[] znaky = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int[] tecky = new int[] {1, 3, 2, 2, 1, 3, 1, 4, 2, 1, 1, 3, 0, 1, 0, 2, 1, 2, 3, 0, 2, 3, 1, 2, 1, 2, 0, 1, 2, 3, 4, 5, 4, 3, 2, 1};
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int vysledek = 0;
    while (sc.hasNext()) {
      String vstup = sc.next();
      for (int i = 0; i < vstup.length(); i ++) {
        vysledek += tecky[abeceda.indexOf(vstup.charAt(i))];
      }
    }
    System.out.print(vysledek);
  }
}