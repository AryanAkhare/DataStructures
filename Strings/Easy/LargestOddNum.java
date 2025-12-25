package Easy;

/**
 * LeetCode 1903 – Largest Odd Number in String
 *
 * Problem Statement:
 * Given a numeric string `s`, return the largest-valued odd integer 
 * (as a substring of s). If no odd number exists, return an empty string "".
 *
 * Example:
 * Input: s = "35420"
 * Output: "35"
 *
 * ----------------------------------------------------------
 * Brute Force:
 *   - Generate all substrings, check if they form odd numbers.
 *   - Compare and track the maximum.
 *   - Time: O(n^2), not efficient.
 *
 * Better Approach:
 *   - Iterate from left, keep checking substrings ending at i.
 *   - Time: O(n^2), still heavy.
 *
 * Optimal Approach:
 *   - The number must end with an odd digit (1,3,5,7,9).
 *   - Traverse from right to left; the first odd digit found gives the answer.
 *   - Return substring up to that index.
 *   - Time: O(n), Space: O(1).
 * ----------------------------------------------------------
 */

public class LargestOddNum {

    // Function to return largest odd number from string
    public static String maxOddNum(String s) {
        // Traverse from rightmost digit
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            // Convert char to int and check if it's odd
            if ((c - '0') % 2 == 1) {
                // Substring from 0 till current index (inclusive)
                return s.substring(0, i + 1);
            }
        }
        // If no odd digit found
        return "";
    }

    // Driver code for quick test
    public static void main(String[] args) {
        String s = "35420";
        System.out.println(maxOddNum(s)); // Output: "35"
    }
}
