package lekce_17;

class Utilities {
    public Utilities() {}

    public static boolean isNotInList(char character, char[] list) {  // kontroluje, jestli pismeno neni v listu
        for (int i = 0; i < list.length; i += 1) {
            if (list[i] == character) {
                return false;
            }
        }
        return true;
    }

    public static char[] enlargeList(char[] oldlist) { // zvetsi list o 1
        char[] newlist = new char[oldlist.length + 1];
        for (int i = 0; i < oldlist.length; i += 1) {
            newlist[i] = oldlist[i];
        }
        return newlist;
    }

    public static char[] convertToUpperCase(char[] lowCaseList) { // vsechny itemy listu se zmeni v UpperCase
        char[] upperCaseList = new char[lowCaseList.length];
        for (int i = 0; i < lowCaseList.length; i += 1) {
            upperCaseList[i] = Character.toUpperCase(lowCaseList[i]);
        }
        return upperCaseList;
    }

    public static char[] getInput() { // vrati list pismen, ktery byl rozlozen z uzivatelskeho inputu
        char[] list = new char[0];
        String word;
        int index = 0;
        char ch;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (sc.hasNext()) {
            word = sc.nextLine();
            for (int i = 0; i < word.length(); i += 1) {
                ch = Character.toUpperCase(word.charAt(i));
                if (!isNotInList(ch, Cipher.ALPHABET)) { // kontroluje, jestli input neni nezasifrovatelny znak
                    list = enlargeList(list);
                    list[index] = ch;
                    index += 1;
                }
            }
        }
        sc.close();
        return list;
    }
}


class Cipher {
    private char[] keyword;
    private char[][] table = new char[5][5];
    public static final char[] ALPHABET = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    
    public Cipher(String keywordString) {
        this.keyword = keywordString.toCharArray();
    }

    public void fillTable() { // vyplni tabulku pomoci klice a zbytku abecedy
        char[] allInLine = new char[25];
        int index = 0;
        formatKeyword();
        // vyplneni klice do radku
        for (int i = 0; i < this.keyword.length; i += 1) {
            if (Utilities.isNotInList(keyword[i], allInLine)) {
                allInLine[index] = this.keyword[i];
                index += 1;
            }
        }
        // doplneni radku zbytkem abecedy [i = index, ktery uz je prvni nevyplneny]
        for (int i = index; i < 25; i += 1) {
            for (int n = 0; n < this.ALPHABET.length; n += 1) {
                if (Utilities.isNotInList(this.ALPHABET[n], allInLine)) {
                    allInLine[i] = this.ALPHABET[n];
                    break;
                }
            }
        }
        // rozdeleni radku do tabulky
        for (int radek = 0; radek < 5; radek += 1) {
            for (int sloupec = 0; sloupec < 5; sloupec += 1) {
                this.table[radek][sloupec] = allInLine[radek * 5 + sloupec];
            }
        }
    }

    private void formatKeyword() { // zmeni klic do pozadovane formy
        this.keyword = Utilities.convertToUpperCase(this.keyword);
        for (int i = 0; i < this.keyword.length; i += 1) {
            if (this.keyword[i] == 'J') {
                this.keyword[i] = 'I';
            }
        }
    }

    public void printTable() { // vytiskne tabulku
        for (int radek = 0; radek < 5; radek += 1) {
            for (int sloupec = 0; sloupec < 5; sloupec += 1) {
                System.out.printf("%3c", this.table[radek][sloupec]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[] getPosition(char character) { // vrati pozici pismena v tabulce {radek, sloupec}
        for (int line = 0; line < 5; line += 1) {
            for (int column = 0; column < 5; column += 1) {
                if (character == this.table[line][column]) {
                    return new int[] {line, column};
                }
            }
        }
        return new int[] {0, 0};
    }

    public char[] decryptPair(char[] pair) { // rozlusti dvojici
        int[] char1 = getPosition(pair[0]);
        int[] char2 = getPosition(pair[1]);
        char decrchar1;
        char decrchar2;

        if (char1[1] == char2[1]) {
            if (char1[0] == 0) {
                decrchar1 = this.table[4][char1[1]];
                decrchar2 = this.table[char2[0] - 1][char2[1]];
            } else if (char2[0] == 0) {
                decrchar1 = this.table[char1[0] - 1][char1[1]];
                decrchar2 = this.table[4][char1[1]];
            } else {
                decrchar1 = this.table[char1[0] - 1][char1[1]];
                decrchar2 = this.table[char2[0] - 1][char2[1]];
            }
        } else if (char1[0] == char2[0]) {
            if (char1[1] == 0) {
                decrchar1 = this.table[char1[0]][4];
                decrchar2 = this.table[char2[0]][char2[1] - 1];
            } else if (char2[1] == 0) {
                decrchar1 = this.table[char1[0]][char1[1] - 1];
                decrchar2 = this.table[char2[0]][4];
            } else {
                decrchar1 = this.table[char1[0]][char1[1] - 1];
                decrchar2 = this.table[char2[0]][char2[1] - 1];
            }
        } else {
            decrchar1 = this.table[char1[0]][char2[1]];
            decrchar2 = this.table[char2[0]][char1[1]];
        }
        

        return new char[] {decrchar1, decrchar2};
    }

    public void decrypt(char[] message) { // vytiskne rozlustenou zpravu
        char[] decryptedPair = new char[2];
        for (int i = 0; i < message.length; i += 2) {
            decryptedPair = decryptPair(new char[] {message[i], message[i + 1]});
            System.out.printf("%c%c", decryptedPair[0], decryptedPair[1]);
        }
    }

    public char[] encryptPair(char[] pair) { // zasifruje dvojici podle tabulky
        int[] char1 = getPosition(pair[0]);
        int[] char2 = getPosition(pair[1]);
        char encrchar1;
        char encrchar2;

        if (char1[1] == char2[1]) {
            if (char1[0] == 4) {
                encrchar1 = this.table[0][char1[1]];
                encrchar2 = this.table[char2[0] + 1][char2[1]];
            } else if (char2[0] == 4) {
                encrchar1 = this.table[char1[0] + 1][char1[1]];
                encrchar2 = this.table[0][char1[1]];
            } else {
                encrchar1 = this.table[char1[0] + 1][char1[1]];
                encrchar2 = this.table[char2[0] + 1][char2[1]];
            }
        } else if (char1[0] == char2[0]) {
            if (char1[1] == 4) {
                encrchar1 = this.table[char1[0]][0];
                encrchar2 = this.table[char2[0]][char2[1] + 1];
            } else if (char2[1] == 4) {
                encrchar1 = this.table[char1[0]][char1[1] + 1];
                encrchar2 = this.table[char2[0]][0];
            } else {
                encrchar1 = this.table[char1[0]][char1[1] + 1];
                encrchar2 = this.table[char2[0]][char2[1] + 1];
            }
        } else {
            encrchar1 = this.table[char1[0]][char2[1]];
            encrchar2 = this.table[char2[0]][char1[1]];
        }
        

        return new char[] {encrchar1, encrchar2};
    }

    public void encrypt(char[] message) { // vytiskne zasifrovanou zpravu
        char[] pair = new char[2];
        char[] encryptedPair = new char[2];
        int index = 0;
        int alreadyPrinted = 0;
        // rozdeleni do dvojic
        while (index < message.length) {
            pair[0] = message[index];
            if (index != (message.length - 1)) {
                if (message[index + 1] == pair[0]) {
                    pair[1] = 'X';
                    index += 1;
                } else {
                    pair[1] = message[index + 1];
                    index += 2;
                }
            } else {
                pair[1] = 'X';
                index += 1;
            }
            // zasifrovani dvojice
            encryptedPair = encryptPair(pair);
            // vytisknuti dvojice
            for (int i = 0; i < 2; i += 1) {
                if ((alreadyPrinted % 5 == 0) && (alreadyPrinted > 1)) {
                    System.out.print(" ");
                }
                System.out.print(encryptedPair[i]);
                alreadyPrinted += 1;
            }
        }
    }
}


public class Playfair {
    public static void main(String args[]) {
        String type = args[0];
        String keyword = args[1];
        char[] message = Utilities.getInput();
        Cipher cipher = new Cipher(keyword);
        cipher.fillTable();
        cipher.printTable();
        if (type.equals("decrypt")) {
            cipher.decrypt(message);
        } else if (type.equals("encrypt")) {
            cipher.encrypt(message);
        }
    }
}
