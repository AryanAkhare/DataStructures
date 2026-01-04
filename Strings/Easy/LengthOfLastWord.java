package Strings.Easy;

public class LengthOfLastWord {

    /*
     INTUITION (TUF STYLE):
     - The last word is present at the end of the string.
     - First, skip all trailing spaces since they do not belong to any word.
     - Once a non-space character is found, start counting characters.
     - Keep counting until a space is encountered or string ends.
     - The count obtained is the length of the last word.
     */

    public static int LengthOfLastWord(String s) {
        int len = 0;
        int i = s.length() - 1;

        // Step 1: Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: Count characters of last word
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }

        return len;
    }
}
