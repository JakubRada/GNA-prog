//package lekce_23;


import java.util.ArrayList;
import java.util.Scanner;

public class Zarovnani {
	
	public static ArrayList<String> nacti() {
		ArrayList<String> text = new ArrayList<String>();
		Scanner sc = new Scanner(System.in).useDelimiter(" ");
		
		while (sc.hasNext()) {
			text.add(sc.next());
		}
		System.out.println(text);
		sc.close();
		return text;
	}
	
	public static void main(String[] args) {
		final int SIRKA = 25;
		int radek = 0;
		ArrayList<String> text = nacti();
		
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
