//package lekce_23;


import java.util.ArrayList;
import java.util.Scanner;

public class Zarovnani {

	public static ArrayList<String> nacti() {
		ArrayList<String> text = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		String a;
		String[] x;
		while (sc.hasNextLine()) {
			a = sc.nextLine();
			if (a.equals("") || a.equals(" ")) {
				text.add("\n");
			} else {
				x = a.split(" ");
				for (String o: x) {
					text.add(o);
				}
			}
		}
		sc.close();
		System.out.println("~~~list slov~~~");
		System.out.println(text);
		return text;
	}
	
	public static void main(String[] args) {
		final int SIRKA = 25;
		int radek = 0;
		ArrayList<String> text = nacti();
		System.out.println("~~~zacatek tisku~~~");
		for (String slovo : text) {
			radek += slovo.length();
			if (radek > SIRKA) {
				radek = slovo.length();
				System.out.println();
			} 
			System.out.printf("%s ", slovo);
			radek += 1;
		}

	}

}
