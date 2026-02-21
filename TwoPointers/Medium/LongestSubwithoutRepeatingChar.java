package TwoPointers.Medium;

import java.util.*;

public class LongestSubwithoutRepeatingChar {

    /*
    ===============================================================
    PROBLEM STATEMENT:
    ---------------------------------------------------------------
    Given a string s, find the length of the longest substring 
    without repeating characters.

    Example:
    Input:  "abcabcbb"
    Output: 3
    Explanation: "abc" is the longest substring without duplicates.

    ===============================================================
    ---------------------------------------------------------------
    BRUTE FORCE APPROACH (O(n^2))
    ---------------------------------------------------------------
    INTUITION:
    - For every starting index i
    - Try to expand substring using j
    - Stop when duplicate appears
    - Track maximum length

    WHY IT WORKS:
    - We try all possible substrings starting from each index.
    - If duplicate appears, we stop expanding.

    TIME COMPLEXITY:
    - Outer loop runs n times
    - Inner loop runs up to n times
    => O(n^2)

    SPACE COMPLEXITY:
    - boolean[256] array
    => O(1) (constant space)
    ===============================================================
    */

    public static int bruteForce(String s) {

        int n = s.length();
        int max = 0;

        for (int i = 0; i < n; i++) {

            boolean[] visited = new boolean[256];
            int count = 0;

            for (int j = i; j < n; j++) {

                if (visited[s.charAt(j)]) {
                    break; // duplicate found
                }

                visited[s.charAt(j)] = true;
                count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    /*
    ===============================================================
    ---------------------------------------------------------------
    OPTIMAL APPROACH (Sliding Window + HashMap)
    ---------------------------------------------------------------
    INTUITION:
    - Use two pointers (left and right)
    - Expand right pointer
    - If duplicate appears:
        move left pointer to index after last occurrence
    - Keep updating maximum length

    KEY IDEA:
    - Instead of restarting from every index (like brute),
      we reuse previous window.
    - This avoids repeated work.

    TIME COMPLEXITY:
    - Each character visited once
    => O(n)

    SPACE COMPLEXITY:
    - HashMap stores at most n characters
    => O(n)
    ===============================================================
    */

    public static int optimal(String s) {

        int n = s.length();
        int max = 0;
        int left = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {

            char ch = s.charAt(right);

            // If duplicate inside current window
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            map.put(ch, right);

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    /*
    ===============================================================
    SUMMARY:
    ---------------------------------------------------------------
    Brute:
        Time  -> O(n^2)
        Space -> O(1)

    Optimal (Sliding Window):
        Time  -> O(n)
        Space -> O(n)

    Sliding window avoids recomputation and improves efficiency.
    ===============================================================
    */

}