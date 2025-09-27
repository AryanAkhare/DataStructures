package Easy;

/**
 * LeetCode 1021 – Remove Outermost Parentheses
 *
 * Problem Statement:
 * A valid parentheses string is either empty, "(", ")", or a combination of them that is balanced.
 * A primitive valid parentheses string is one that cannot be split further into non-empty valid strings.
 * Given a valid parentheses string s, remove the outermost parentheses of every primitive substring.
 *
 * Example:
 * Input: s = "(()())(())(()(()))"
 * Output: "()()()()(())"
 *
 * Approach:
 * - Use a counter `count` to track the depth of parentheses.
 * - For every '(':
 *      - If `count > 0`, it's not the outermost, so append it.
 *      - Increment `count`.
 * - For every ')':
 *      - Decrement `count`.
 *      - If `count > 0`, it's not the outermost, so append it.
 * - This ensures outermost '(' and ')' of each primitive are skipped.
 *
 * Time Complexity: O(N), where N = length of string (one pass traversal).
 * Space Complexity: O(N), for the StringBuilder result.
 */

public class RemoveOutermostParanthesis {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder(); // Efficient for building result
        int count = 0; // Track depth of parentheses

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                if (count > 0) {
                    result.append(c); // keep only if not outermost
                }
                count++;
            } else { // c == ')'
                count--;
                if (count > 0) {
                    result.append(c); // keep only if not outermost
                }
            }
        }
        return result.toString();
    }
}
