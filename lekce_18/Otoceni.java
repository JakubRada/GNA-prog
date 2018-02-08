// package lekce_18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Otoceni {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			input.add(sc.nextInt());
		}
		sc.close();
		for (int i = input.size() - 1; i >= 0; i -= 1) {
			System.out.printf("%d ", input.get(i));
		}
	}

}
