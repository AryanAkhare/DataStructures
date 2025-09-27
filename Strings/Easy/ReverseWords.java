package Easy;

/**
 * Reverse Words in a String – Multiple Approaches
 *
 * Problem Statement:
 * Given a string s, reverse the order of words.
 * Words can be separated by spaces or dots (.) depending on the variant.
 * The reversed string should have only a single separator between words,
 * and no leading/trailing separators.
 *
 * Example 1 (spaces):
 * Input: s = "  the sky  is blue "
 * Output: "blue is sky the"
 *
 * Example 2 (dots):
 * Input: s = "..hello..world..java.."
 * Output: "java.world.hello"
 *
 * Approach 1: Simple split() method
 * Approach 2: Manual scan (Optimal)
 * Approach 3: Dot-separated words handling
 *
 * Time Complexity: O(N) for all approaches
 * Space Complexity:
 * - Approach 1: O(N) for words array + StringBuilder
 * - Approach 2: O(N) for StringBuilder only
 * - Approach 3: O(N) for words array + StringBuilder
 */

public class ReverseWords {

    // --------------------------
    // Approach 1: Using split() (Space-separated words)
    // Intuition: Split by spaces, reverse array, join words
    // --------------------------
    class SolutionSplit {
        String reverseWords(String s) {
            String[] words = s.trim().split("\\s+"); // split by one or more spaces
            StringBuilder res = new StringBuilder();

            for (int i = words.length - 1; i >= 0; i--) {
                res.append(words[i]);
                if (i != 0) res.append(" "); // add single space between words
            }

            return res.toString();
        }
    }

    // --------------------------
    // Approach 2: Manual scan (Optimal, Space-separated)
    // Intuition: Scan string from end to start, identify words manually
    // --------------------------
    class SolutionManual {
        String reverseWords(String s) {
            StringBuilder res = new StringBuilder();
            int i = s.length() - 1;

            while (i >= 0) {
                // Skip trailing spaces
                while (i >= 0 && s.charAt(i) == ' ') i--;

                if (i < 0) break;

                // Mark end of word
                int j = i;
                // Move i backwards to start of word
                while (i >= 0 && s.charAt(i) != ' ') i--;

                // Append word to result
                if (res.length() > 0) res.append(' '); // single space
                res.append(s.substring(i + 1, j + 1));
            }

            return res.toString();
        }
    }

    // --------------------------
    // Approach 3: Dot-separated words
    // Intuition: Split by dot, skip empty strings, reverse array, join with single dot
    // --------------------------
    String reverseWordsByDot(String s) {
        String[] words = s.split("\\."); // split by dot
        StringBuilder res = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) { // skip empty strings from multiple dots
                if (res.length() > 0) res.append('.'); // add single dot
                res.append(words[i]);
            }
        }

        return res.toString();
    }

    /**
     * Time Complexity (All approaches): O(N)
     * Space Complexity:
     * - Approach 1: O(N) for words array + StringBuilder
     * - Approach 2: O(N) for StringBuilder only
     * - Approach 3: O(N) for words array + StringBuilder
     *
     * Edge Cases Handled:
     * - Leading/trailing separators
     * - Multiple consecutive separators
     * - Empty string input
     *
     * Key Takeaways:
     * - Approach 1 is simple and readable.
     * - Approach 2 is optimal for interviews (manual scanning, no extra array needed).
     * - Approach 3 demonstrates handling custom separators (dots, commas, etc.).
     */
}
