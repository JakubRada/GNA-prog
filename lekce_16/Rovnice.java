import cz.alisma.alej.prog.pg16.QuadraticEquationGenerator;
import cz.alisma.alej.prog.pg16.QuadraticEquationPrinter;

interface ExtendedQuadraticEquationPrinter extends QuadraticEquationPrinter {
    public void printResults();
}

class Results {
    public Results() {}
    public static int[][] addResultsToList(int[][] oldList, int value1, int value2) {
        int [][] newList = new int[oldList.length + 1][2];
        for (int i = 0; i < oldList.length; i += 1) {
            newList[i] = oldList[i];
        }
        newList[newList.length - 1][0] = value1;
        newList[newList.length - 1][1] = value2;
        return newList;
    }
    public static void printAllValuesScreen (int[][] list) {
        System.out.println();
        for (int i = 0; i < list.length; i += 1) {
            System.out.printf("%d a %d\n", list[i][0], list[i][1]);
        }
    }
    public static void printAllVaulesHtml (int[][] list) {
        System.out.println("\t\t<br>\n");
        for (int i = 0; i < list.length; i += 1) {
            System.out.printf("\t\t%d a %d<br>\n", list[i][0], list[i][1]);
        }
    }

    public static boolean condition(int result1, int result2, int usedResult, int newResult) {
        if (usedResult == result1) {
            if (newResult == result2) {
                return true;
            } else {
                return false;
            }
        } else {
            if (newResult == result1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static int getIntInput(){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        return sc.nextInt();
    }

    public static void test(int result1, int result2) {
        int usedResult = 0;
        int inputResult;
        int status = 0;
        while (status == 0) {
            System.out.print("First result: ");
            inputResult = getIntInput();
            if (inputResult == result1 || inputResult == result2) {
                System.out.print("Correct\n\n");
                usedResult = inputResult;
                status = 1;
            } else {
                System.out.print("Wrong\n\n");
            }
        }
        while (status == 1) {
            System.out.print("Second result: ");
            inputResult = getIntInput();
            if (condition(result1, result2, usedResult, inputResult)) {
                System.out.print("Correct\n\n");
                status = 0;
            } else {
                System.out.print("Wrong or already used\n\n");
            }
        }
    }
}

class TestingPrinter implements ExtendedQuadraticEquationPrinter {
    public TestingPrinter() {}
    public void printResults() {}
    public void printEquation(int a, int b, int c, int x1, int x2) {
        System.out.printf("%dx^2 ", a);
        if (b > 0) {
            System.out.printf("+ %dx ", b);
        } else if (b != 0) {
            System.out.printf("- %dx ", Math.abs(b));
        }
        if (c > 0) {
            System.out.printf("+ %d = 0\n", c);
        } else if (c != 0) {
            System.out.printf("- %d = 0\n", Math.abs(c));
        }
        Results.test(x1, x2);
    }
}

class ScreenPrinter implements ExtendedQuadraticEquationPrinter {
    int[][] resultList = new int[0][2];
    public ScreenPrinter() {}
    public void printEquation(int a, int b, int c, int x1, int x2) {
        System.out.printf("%dx^2 ", a);
        if (b > 0) {
            System.out.printf("+ %dx ", b);
        } else if (b != 0) {
            System.out.printf("- %dx ", Math.abs(b));
        }
        if (c > 0) {
            System.out.printf("+ %d = 0\n", c);
        } else if (c != 0) {
            System.out.printf("- %d = 0\n", Math.abs(c));
        }
        resultList = Results.addResultsToList(resultList, x1, x2);
    }
    public void printResults() {
        Results.printAllValuesScreen(resultList);
    }
}

class HtmlPrinter implements ExtendedQuadraticEquationPrinter {
    int[][] resultList = new int[0][2];
    public HtmlPrinter() {}
    public void printEquation(int a, int b, int c, int x1, int x2) {
        System.out.printf("\t\t%dx^2 ", a);
        if (b > 0) {
            System.out.printf("+ %dx ", b);
        } else if (b != 0) {
            System.out.printf("- %dx", Math.abs(b));
        }
        if (c > 0) {
            System.out.printf("+ %d = 0<br>\n", c);
        } else if (c != 0) {
            System.out.printf("- %d = 0<br>\n", Math.abs(c));
        }
        resultList = Results.addResultsToList(resultList, x1, x2);
    }
    public void printResults() {
        Results.printAllVaulesHtml(resultList);
    }
}

public class Rovnice {
    public static void main(String[] args) {
        int type = Integer.parseInt(args[0]);
        ExtendedQuadraticEquationPrinter printer;
        if (type == 0) {
            System.out.print("<!DOCTYPE html>\n<html>\n\t<head>\n\t\t<title>\n\t\t\tQuadratic Equations\n\t\t</title>\n\t</head>\n\t<body>\n");
            printer = new HtmlPrinter();
        } else if (type == 1) {
            printer = new ScreenPrinter();
        } else {
            printer = new TestingPrinter();
        }
        QuadraticEquationGenerator.generate(10, printer);
        printer.printResults();
        if (type == 0) {
            System.out.print("\t</body>\n</html>\n");
        }
    }
}
