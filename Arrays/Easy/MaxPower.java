/*
========================================================
Problem Statement:
Given a string s, return the length of the longest 
substring containing the same character consecutively.

Example:
Input: "abbcccddddeeeeedcba"
Output: 5
(eeee e → length = 5)
========================================================
*/

public class MaxPower {

    /*
    ========================================================
    🧠 INTUITION:

    We need longest consecutive same character streak.

    Key Idea:
    - Compare current character with previous one
    - If same → increase streak
    - If different → reset streak to 1
    - Track maximum streak

    This is a simple linear scan pattern.
    ========================================================
    */

    // -----------------------------------------------------
    // 1️⃣ BRUTE FORCE APPROACH
    // -----------------------------------------------------
    /*
    Idea:
    - For every index, expand forward
    - Count how many consecutive characters match

    Time Complexity: O(n^2)
    Space Complexity: O(1)
    */

    public static int bruteForce(String s) {

        int max = 1;

        for (int i = 0; i < s.length(); i++) {

            int count = 1;

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }

            max = Math.max(max, count);
        }

        return max;
    }

    // -----------------------------------------------------
    // 2️⃣ OPTIMAL APPROACH (Linear Scan)
    // -----------------------------------------------------
    /*
    Idea:
    - Traverse once
    - Compare with previous character
    - Maintain running streak

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public static int optimal(String s) {

        if (s.length() == 0)
            return 0;

        int count = 1;
        int max = 1;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    // -----------------------------------------------------
    // Main Method (Testing)
    // -----------------------------------------------------
    public static void main(String[] args) {

        String s = "abbcccddddeeeeedcba";

        System.out.println("Brute Force: " + bruteForce(s));
        System.out.println("Optimal: " + optimal(s));
    }
}