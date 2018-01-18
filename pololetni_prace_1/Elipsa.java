package pololetni_prace_1;

public class Elipsa {
  public static int mocnina(int cislo){
    return cislo * cislo;
  }
  public static boolean je_v_elipse(int x, int y, int a, int b) {
    if ((mocnina(x) * mocnina(b) + mocnina(y) * mocnina(a)) < mocnina(a) * mocnina(b)){  //kdyby zde misto < bylo <=, vykreslilo by to navic jeste jeden krizek v obou smerech obou poloos
      return true;
    } else {
      return false;
    } 
  }
  public static void main(String[] args){
    int velka_poloosa = Integer.parseInt(args[0]);
    int mala_poloosa = Integer.parseInt(args[1]);
    for(int y = -mala_poloosa; y <= mala_poloosa; y += 1) {
      for(int x = -velka_poloosa; x <= velka_poloosa; x += 1) {
        if (je_v_elipse(x, y, velka_poloosa, mala_poloosa)) {
          System.out.print("X");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}