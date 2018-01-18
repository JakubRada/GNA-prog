package lekce_7;

public class Krizek {
    public static void PrintChar(char letter, int number){
        for (int n = number; n > 0; n -= 1) {
            System.out.print(letter);
        }
    }
    public static void PrintVertical (char letter_1, char letter_2, int height, int indent) {
        for (int i = height; i > 0; i -= 1){
            PrintChar(letter_1, height + indent);
            PrintChar(letter_2, height);
            System.out.print('\n');
        }
    }
    public static void PrintHorizontal (char letter, int height, int indent) {
        for (int i = height - 1; i > 0; i -= 1) {
            PrintChar('X', 3 * height + 2 * indent);
            System.out.print('\n');
        }
    }
    public static void main(String[] args){
        int height = Integer.parseInt(args[0]);
        int indent = 2;
        if (height == 1) {
            PrintVertical(' ', 'X', height, indent - 1);
            PrintChar('X', 2 * indent + height);
            System.out.print('\n');
            PrintVertical(' ', 'X', height, indent - 1);
        } else {
            PrintVertical(' ', 'X', height, indent);
            PrintHorizontal('X', height, indent);
            PrintVertical(' ', 'X', height, indent);
        }
    }
}