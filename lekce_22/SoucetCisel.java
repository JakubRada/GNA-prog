package lekce_22;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

public class SoucetCisel {
	// soubor neexistueje => vyhodim 0
	// zaporne cislo = > vyhodim vyjimku
	public static int soucetSouboru(String soubor) {
		try{
			Reader ctecka = new FileReader(soubor);
			Scanner sc = new Scanner(ctecka);
			int soucet = 0;
			while (sc.hasNextInt()) {
				int pom = sc.nextInt();
				if (pom < 0) {
					throw new NumberFormatException("Cislo je zaporne");
				}
				soucet += pom;
			}
			sc.close();
			return soucet;
		} catch (FileNotFoundException e) {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		try{
			int total = 0;
			for (String soubor: args) {
				total += soucetSouboru(soubor);
			}
			System.out.printf("Soucet je %d\n", total);
		} catch (NumberFormatException e) {
			System.out.println("Cisla nesmi byt zaporna");
		}
	}

}
