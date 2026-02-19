/*
-------------------------------------------------------------
Problem: Binary Number with Alternating Bits

Given a positive integer n,
return true if it has alternating bits,
otherwise return false.

Alternating bits means:
No two adjacent bits are the same.

Example:
n = 5  → 101  → true
n = 7  → 111  → false
-------------------------------------------------------------
*/

public class AlternatingBits {

    public static void main(String[] args) {

        Solution sol = new Solution();

        int n = 5;

        System.out.println("String Approach: " + sol.hasAlternatingBitsString(n));
        System.out.println("Bitwise Loop Approach: " + sol.hasAlternatingBitsBitwise(n));
        System.out.println("Optimized XOR Approach: " + sol.hasAlternatingBitsOptimized(n));
    }
}

class Solution {

    /*
    -------------------------------------------------------------
    Approach 1: Convert to Binary String
    Intuition:
    - Convert number to binary string.
    - Check if any adjacent characters are same.
    - If yes → return false.
    - Else → return true.

    Time: O(n)
    Space: O(n)
    -------------------------------------------------------------
    */
    public boolean hasAlternatingBitsString(int n) {

        String s = Integer.toBinaryString(n);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }

    /*
    -------------------------------------------------------------
    Approach 2: Pure Bitwise (No String)

    Intuition:
    - Compare last bit with next bit.
    - Use (n & 1) to get last bit.
    - Shift right and compare repeatedly.

    Time: O(log n)
    Space: O(1)
    -------------------------------------------------------------
    */
    public boolean hasAlternatingBitsBitwise(int n) {

        int prev = n & 1;
        n = n >> 1;

        while (n > 0) {

            int curr = n & 1;

            if (curr == prev) {
                return false;
            }

            prev = curr;
            n = n >> 1;
        }

        return true;
    }

    /*
    -------------------------------------------------------------
    Approach 3: Optimized Bit Trick (Best)

    Intuition:
    If bits are alternating:

    n        = 101010
    n >> 1   = 010101
    XOR      = 111111  (all 1s)

    A number with all 1s satisfies:
    x & (x + 1) == 0

    Time: O(1)
    Space: O(1)
    -------------------------------------------------------------
    */
    public boolean hasAlternatingBitsOptimized(int n) {

        int x = n ^ (n >> 1);

        return (x & (x + 1)) == 0;
    }
}
