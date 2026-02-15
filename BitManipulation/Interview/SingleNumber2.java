import java.util.HashMap;

/*
==========================================================
 PROBLEM: Single Number II
----------------------------------------------------------
Given an integer array nums where:
- Every element appears THREE times
- Except one element which appears ONCE

Return the element that appears only once.

Example:
Input:  [2, 2, 3, 2]
Output: 3
==========================================================
*/

public class SingleNumber2 {

    /*
    ==========================================================
    APPROACH 1: Brute Force (HashMap)
    ----------------------------------------------------------
    INTUITION:
    - Count frequency of each number using HashMap.
    - Return the number whose frequency is 1.
    ==========================================================
    */

    public static int singleNumberBrute(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find element with frequency 1
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }

    /*
    Time Complexity: O(n)
    Space Complexity: O(n)
    */




    /*
    ==========================================================
    APPROACH 2: Bit Counting (Better)
    ----------------------------------------------------------
    INTUITION:
    - Check each of 32 bits.
    - Count how many numbers have that bit set.
    - Since duplicates appear 3 times,
      count % 3 gives the unique bit.
    ==========================================================
    */

    public static int singleNumberBitCount(int[] nums) {

        int ans = 0;

        // Check all 32 bits
        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {

            int count = 0;

            for (int num : nums) {
                // Check if current bit is set
                if ((num & (1 << bitIndex)) != 0) {
                    count++;
                }
            }

            // If remainder is 1 → unique number has this bit
            if (count % 3 == 1) {
                ans |= (1 << bitIndex);
            }
        }

        return ans;
    }

    /*
    Time Complexity: O(32 * n) ≈ O(n)
    Space Complexity: O(1)
    */




    /*
    ==========================================================
    APPROACH 3: Optimal (Ones & Twos Method)
    ----------------------------------------------------------
    INTUITION:
    - Track bits appearing once using "ones".
    - Track bits appearing twice using "twos".
    - When bit appears third time → removed automatically.

    State Cycle for each bit:
        Count 0 → (0,0)
        Count 1 → (1,0)
        Count 2 → (0,1)
        Count 3 → (0,0)
    ==========================================================
    */

    public static int singleNumberOptimal(int[] nums) {

        int ones = 0;
        int twos = 0;

        for (int num : nums) {

            // Add to ones if not in twos
            ones = (ones ^ num) & ~twos;

            // Add to twos if not in ones
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }

    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
    */




    // ================= TESTING =================

    public static void main(String[] args) {

        int[] nums = {2, 2, 3, 2};

        System.out.println("Brute: " + singleNumberBrute(nums));
        System.out.println("BitCount: " + singleNumberBitCount(nums));
        System.out.println("Optimal: " + singleNumberOptimal(nums));
    }
}
