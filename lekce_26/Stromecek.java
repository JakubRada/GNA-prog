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
			if (args[0].equals("-d")) {
    			printFiles(new File("."), "", true);
    		} else {
    			printFiles(new File("."), "", false);
    		}
    	} else {
    		printFiles(new File("."), "", false);
    	}
    }
 
    private static void printFiles(File dir, String indent, boolean folder) {
        File[] files = dir.listFiles();
        int count = 0;
		int len;
		if (folder) {
			len = 0;
			for (File f : files) {
				if (f.isDirectory()) {
					len += 1;
				}
			}
		} else {
			len = files.length;
		}
        for (File f : files) {
        	count += 1;
			if (folder) {
				if (count == len && f.isDirectory()) {
        			System.out.printf("%s`--%s\n", indent, f.getName());
        		} else if (count < len && f.isDirectory()) {
        			System.out.printf("%s|--%s\n", indent, f.getName());
        		}
			} else {
				if (count == len) {
        			System.out.printf("%s`--%s\n", indent, f.getName());
        		} else {
        			System.out.printf("%s|--%s\n", indent, f.getName());
        		}
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