/*
|-- PseudoFork.java
|-- ch
|    `-- usi
|          `-- dag
|                `-- dislrunner
|                      |-- JavaProcessBuilder.java
|                      |-- Runner.java
|                      `-- SysUtils.java
`-- StartDiSL.java
*/
import java.io.File;
 
public class Stromecek {
    public static void main(String[] args) {
        printFiles(new File("."), "");
    }
 
    private static void printFiles(File dir, String indent) {
        File[] files = dir.listFiles();
        int len = files.length;
        int count = 0;
        for (File f : files) {
        	count += 1;
        	if (indent.equals("") == false) {
        		System.out.print("|");
        	}
        	if (count == len) {
        		System.out.printf("%s`--%s\n", indent, f.getName());
        	} else {
        		System.out.printf("%s|--%s\n", indent, f.getName());
        	}
        	if (f.isDirectory()) {
                printFiles(f, indent + "  ");
            }
        }
    }
}