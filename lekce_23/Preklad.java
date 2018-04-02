import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Preklad {

	public static ArrayList<String> ziskejText (String jmeno) throws IOException {
		FileReader reader = new FileReader(jmeno);
		Scanner sc = new Scanner(reader);
		ArrayList <String> text = new ArrayList<String>();
		while (sc.hasNext()) {
			text.add(sc.next());
		}
		sc.close();
		return text;
	}

	public static HashMap<String, String> ziskejSlovink (String jmeno) throws IOException {
		FileReader reader = new FileReader(jmeno);
		HashMap <String, String> slovnik = new HashMap<String, String>();
		Scanner sc = new Scanner(reader);
		String radek;
		String[] radekArr = new String[2];
		while (sc.hasNextLine()) {
			radek = sc.nextLine();
			radekArr = radek.split(" ");
			slovnik.put(radekArr[0], radekArr[1]);
		}
		sc.close();
		return slovnik;
	}

	public static void prelozText(ArrayList<String> text, HashMap<String, String> slovnik) {
		ArrayList<String> preklad = new ArrayList<String>();
		String a;
		for(String slovo : text) {
			a = slovnik.get(slovo);
			if (a == null) {
				System.out.print("?? ");
			} else {
				System.out.printf("%s ", a);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		try {
			final String slovnik = args[0];
			final String text = args[1];
			HashMap<String, String> dict = ziskejSlovink(slovnik);
			ArrayList<String> txt = ziskejText(text);
			prelozText(txt, dict);
		} catch (Exception ex) {
			System.out.println("Arguement is missing");
		}
	}
}