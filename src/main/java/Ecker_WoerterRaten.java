import java.util.Scanner;

public class Ecker_WoerterRaten {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Non-Schleife
        System.out.println("WOERTERRATEN");
        System.out.println("------------");
        String word = "Java";
        boolean keepRunning = true;
        String result = generateResult(word.length());

        while (keepRunning) {
            System.out.print("Gesuchtes Wort: ");
            System.out.println(result);
            char hint = input(scanner);
            result = syncroniseResult(hint, result, word);
            keepRunning = detectWin(word, result, keepRunning);
        }

        winnerMessage(result);
    }

    private static void winnerMessage(String result) {
        System.out.println();
        System.out.println("Das Wort war " + result);
        System.out.println();
        System.out.println("===============");
        System.out.println("====Victory====");
        System.out.println("===============");
    }

    private static boolean detectWin(String word, String result, boolean keepRunning) {
        int correctChars = 0;
        for (int i = 0; i < word.length(); i++) {
            if (result.charAt(i) != '.') {
                correctChars++;
            }
            if (correctChars == word.length()) {
                keepRunning = false;
            }
        }
        return keepRunning;
    }

    private static String syncroniseResult(char hint, String result, String word) {
        String helpResult = "";

        for (int i = 0; i <  word.length(); i++) {
            if (Character.toUpperCase(hint) == Character.toUpperCase(word.charAt(i)) || result.charAt(i) != '.') {
                helpResult += word.charAt(i);
            } else {
                helpResult += '.';
            }
        }
        
        return helpResult;
    }

    private static String generateResult(int length) {
        String result = "";

        for (int i = 0; i < length; i++) {
            result += '.';
        }
        return result;
    }

    private static char input(Scanner scanner) {
        String letter = "";
        char letterCharacter;
        do {
            System.out.print("Buchstabe: ");
            letter = scanner.next();

            if (letter.length() != 1) {
                System.out.println();
                System.out.println("Man darf nur einen Buchstaben eingeben!");
                System.out.println();
            }
        } while (letter.length() != 1);
        letterCharacter = letter.charAt(0);
        return letterCharacter;
    }
}
