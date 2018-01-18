package lekce_3;

public class Ramecek{
  public static void main(String args[]){
    int x = Integer.parseInt(args[0]) - 1; //sirka
    int y = Integer.parseInt(args[1]) - 1; //vyska
    int z = Integer.parseInt(args[2]); //tloustka
    for (int i = 0; i <= y + 2 * z; i += 1){
      for (int n = 0; n <= x + 2 * z; n += 1){
        if ((i >= z) && (i <= y + z) && (n >= z) && (n <= x + z)){
          System.out.print(" ");
        } else {
          System.out.print("#");
        }
      }
      System.out.print("\n");
    }
  }
}