package lekce_13;

public class PohybFigurky {
  public static int[] zvetsiList(int[] staryList) {
    int[] novyList = new int[staryList.length + 1];
    for (int i = 0; i < staryList.length; i += 1) {
      novyList[i] = staryList[i];
    }
    return novyList;
  }
  public static int[] zjistiMinulePozice(int[] pole, int pocet) {
    int[] pozice = new int[0];
    for (int i = 0; i < pole.length; i += 1) {
      if (pole[i] == pocet) {
        pozice = zvetsiList(pozice);
        pozice[pozice.length - 1] = i;
      }
    }
    return pozice;
  }
  public static void tisk(int[] pole) {
    for (int i = 0; i < pole.length; i += 1) {
      if (pole[i] != -1) {
        System.out.printf(" %2d", pole[i]);
      } else {
        System.out.print("  -");
      }
    }
    System.out.println();
  }
  public static void main(String[] args) {
    int[] krok = new int[] {3, -3, 5, -5};
    int cil = 4;
    int delkaPole = 9;
    int[] pole = new int[delkaPole];
    for(int i = 1; i < delkaPole; i += 1) {
      pole[i] = -1;
    }
    int[] jsem = new int[1];
    int pocet = 0;
    tisk(pole);
    while (pole[cil] == -1) {
      jsem = zjistiMinulePozice(pole, pocet);
      pocet += 1;
      for (int i = 0; i < jsem.length; i += 1) {
        for (int n = 0; n < 4; n += 1) {
          if ((jsem[i] + krok[n] < delkaPole) && (jsem[i] + krok[n] > 0) && (pole[jsem[i] + krok[n]] == -1)) {
            pole[jsem[i] + krok[n]] = pocet;
          }
        }
      }
      tisk(pole);
    }
    System.out.printf("Potrebne tahy: %d", pole[cil]);
  }
}