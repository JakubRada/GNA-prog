//package lekce_17;

import java.util.Scanner;


public class SoustavaRovnic {
	
	private static void tiskni(String jmeno, int[][] x) {
        System.out.printf("%s\n", jmeno);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.printf("%3d", x[i][j]);
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
	
	
	
	public static void main(String[] args) {
		int pocet = Integer.parseInt(args[0]);
		int[][] matice = new int[pocet][pocet + 1];
		matice = vyplnArray(pocet);
		tiskni("matice", matice);
		
	}

}
