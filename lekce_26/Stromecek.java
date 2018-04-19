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
    	if (args.length > 0) {
    		if (args[0] == "-d"){
    			printFiles(new File("."), "", 1);
    		} else {
    			printFiles(new File("."), "", 0);
    		}
    	} else {
    		printFiles(new File("."), "", 0);
    	}
    }
 
    private static void printFiles(File dir, String indent, int folder) {
        File[] files = dir.listFiles();
        int len = files.length;
        int count = 0;
        for (File f : files) {
        	count += 1;
        	if (count == len) {
        		System.out.printf("%s`--%s\n", indent, f.getName());
        	} else {
        		System.out.printf("%s|--%s\n", indent, f.getName());
        	}
        	if (f.isDirectory()) {
                if (count == len){
                	printFiles(f, indent + "    ", folder);
                } else {
                	printFiles(f, indent + "|   ", folder);
                }
            }
        }
    }
}