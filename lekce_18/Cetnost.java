package lekce_18;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cetnost {

	public static void main(String[] args) {
		Map<Integer, Integer> pocty = new HashMap<>(); 
		Scanner sc = new Scanner(System.in);
		int x;
		while(sc.hasNextInt()) {
			x = sc.nextInt();
			if (pocty.containsKey(x)) {
				pocty.put(x, pocty.get(x) + 1);
			} else {
				pocty.put(x, 1);
			}
		}
		sc.close();
		for (Integer cislo : pocty.keySet()) {
			System.out.printf("%d ... %d\n", cislo, pocty.get(cislo));
		}
	}

}
