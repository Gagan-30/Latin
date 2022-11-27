import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter one or more words that you would like to translate to Pig Latin: ");
        String userInput = input.nextLine();

        String[] word = userInput.split(" ");
        String output = "";

        for (int i = 0; i < word.length; i++) {
            String Latin = translate(word[i]);
            output += Latin + " ";
        }

        System.out.println("Original word = " + userInput);
        System.out.println("output = " + output);
    }

    public static String translate(String word) {
        String lowercase = word.toLowerCase();
        char ch;
        int pos = -1; // first vowel position

        // index of first vowel
        for (int i = 0; i < lowercase.length(); i++) {
            ch = lowercase.charAt(i);

            if (vowel(ch)) {
                pos = i;
                break;
            }
        }
        // first letter is vowel
        if (pos == 0) {
            return lowercase + "yay";
        } else {
            String start = lowercase.substring(pos); //everything after or between 1st to 2nd vowel
            String before = lowercase.substring(0, pos); //everything before 1st vowel
            return start + before + "ay";
        }
    }

    private static boolean vowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}