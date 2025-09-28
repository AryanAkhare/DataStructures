package Easy;

import java.util.Arrays;

/**
 * LeetCode / GFG style problem – Longest Common Prefix
 *
 * Problem Statement:
 * Given an array of strings, find the longest common prefix (LCP) 
 * among all the strings. If no common prefix exists, return "".
 *
 * Example:
 * Input: arr = {"flower","flow","flight"}
 * Output: "fl"
 *
 * Approach (Optimal):
 * 1. Sort the array of strings.
 * 2. Only compare the first and last strings after sorting:
 *    - Sorting ensures that first and last strings will have minimum commonality.
 * 3. Compare characters one by one up to the length of the shorter string.
 * 4. Build the prefix in a StringBuilder.
 * 5. Return the prefix.
 *
 * Time Complexity: O(n log n) for sorting + O(m) for comparison (m = length of shorter string)
 * Space Complexity: O(1) extra space (ignoring output)
 */

public class LongestCommonPrefix {

    // User function Template for Java
    class Solution {
        public String longestCommonPrefix(String arr[]) {
            // StringBuilder to store the answer
            StringBuilder ans = new StringBuilder();

            // Step 1: Sort the array
            Arrays.sort(arr);

            // Step 2: Compare only the first and last strings
            String first = arr[0];
            String last = arr[arr.length - 1];

            // Step 3: Find minimum length to avoid index out of bounds
            int m = Math.min(first.length(), last.length());

            // Step 4: Compare characters one by one
            for (int i = 0; i < m; i++) {
                if (first.charAt(i) != last.charAt(i)) {
                    // Mismatch found → return current prefix
                    return ans.toString();
                }
                // Match found → append to prefix
                ans.append(first.charAt(i));
            }

            // Step 5: Return the prefix
            return ans.toString();
        }
    }
}
