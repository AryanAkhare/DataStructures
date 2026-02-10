/*
========================================================
Problem: Minimum Bit Flips to Convert Number
========================================================

PROBLEM STATEMENT:
------------------
You are given two integers `start` and `goal`.
In one operation, you can flip exactly one bit (0 → 1 or 1 → 0).
Return the minimum number of bit flips required to convert
`start` into `goal`.

--------------------------------------------------------

INTUITION:
----------
1. XOR (`^`) highlights differences between bits.
   - Same bits → 0
   - Different bits → 1

2. Each `1` in (start ^ goal) represents one bit flip needed.

3. So the problem reduces to:
   → Count the number of set bits (1s) in (start ^ goal).

--------------------------------------------------------

EXAMPLE:
--------
start = 10  (1010)
goal  =  7  (0111)

XOR   = 1101  → 3 set bits
Answer = 3

--------------------------------------------------------

TIME COMPLEXITY:
----------------
O(number of bits) ≈ O(32)

SPACE COMPLEXITY:
-----------------
O(1)

========================================================
*/

public class MinBitFlip {

    public int minBitFlips(int start, int goal) {
        int diff = start ^ goal;   // bits that differ
        return countSetBits(diff);
    }

    // Counts number of 1s in binary representation
    private int countSetBits(int n) {
        int count = 0;

        while (n != 0) {
            count += (n & 1);  // check last bit
            n >>= 1;          // shift right
        }

        return count;
    }
}
