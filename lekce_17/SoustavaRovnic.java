// package lekce_17;

import java.util.Scanner;


public class SoustavaRovnic {
	
	private static void tiskni(String jmeno, int[][] x) {
        System.out.printf("%s\n", jmeno);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.printf("%10d", x[i][j]);
            }
            System.out.println();
        }
    }
	
	public static int[][] vyplnArray(int n) {
		int[][] x = new int[n][n + 1];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < n; i += 1) {
			for (int o = 0; o < n + 1; o += 1) {
				x[i][o] = sc.nextInt();
			}
		}
		sc.close();
		return x;
	}
	
	public static int[][] upravMatici(int[][] matice, int pocet) {
		for (int sloupec = 0; sloupec < pocet; sloupec += 1) {
			for (int radek = sloupec + 1; radek < pocet; radek += 1) {
				int koef1 = matice[sloupec][sloupec];
				int koef2 = matice[radek][sloupec];
				if (koef1 != 0) {
					for (int polozka = 0; polozka < pocet + 1; polozka += 1) {
						matice[radek][polozka] = matice[radek][polozka] * koef1 - matice[sloupec][polozka] * koef2;
					}
				}
			}
		}
		return matice;
	}
	

	public static void vysledky(int[][] matice) {
		int[] vysledky = new int[matice.length];
		int pravaStrana;
		for (int i = matice.length - 1; i >= 0 ; i -= 1) {
			pravaStrana = matice[i][matice.length];
			for (int n = i; n < matice.length; n += 1) {
				pravaStrana -= matice[i][n] * vysledky[n];
			}
			if (matice[i][i] == 0) {
				if (pravaStrana == 0) {
					System.out.println("Soustava ma nekonecne mnoho reseni");
					return;
				} else {
					System.out.println("Soustava nema reseni");
					return;
				}
			} else {
				vysledky[i] = pravaStrana / matice[i][i];
			}
		}
		for (int i = 0; i < vysledky.length; i += 1) {
			System.out.printf("x_%d = %d\n", i + 1, vysledky[i]);
		}
		return;
	}

	public static void main(String[] args) {
		int pocet = Integer.parseInt(args[0]);
		int[][] matice = new int[pocet][pocet + 1];
		matice = vyplnArray(pocet);
		matice = upravMatici(matice, pocet);
		vysledky(matice);
	}

}
