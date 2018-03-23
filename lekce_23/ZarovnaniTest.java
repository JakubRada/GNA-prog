package lekce_23;

import static org.junit.Assert.*;

import org.junit.Test;
 
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Scanner;

public class ZarovnaniTest {

	@Test
	public void nacteni() {
		Scanner sc = new Scanner("hello world");
		ArrayList<String> slova = Zarovnani.nacti(sc);
		assertEquals(['hello', 'world'], slova);
		
	}
	
}
