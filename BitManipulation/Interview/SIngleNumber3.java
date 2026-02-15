import java.util.HashMap;

/*
============================================================
 PROBLEM: Single Number III
------------------------------------------------------------
Given an integer array nums where:
- Every element appears twice
- Exactly TWO elements appear once

Return the two elements that appear only once.

Example:
Input:  [1,2,1,3,2,5]
Output: [3,5]  (order does not matter)
============================================================
*/

public class SingleNumber3 {

    /*
    ============================================================
    APPROACH 1: Brute Force (HashMap)
    ------------------------------------------------------------
    INTUITION:
    - Count frequency of each number using HashMap.
    - Collect numbers whose frequency is 1.
    ============================================================
    */

    public static int[] singleNumberBrute(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[2];
        int index = 0;

        // Collect elements with frequency 1
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                result[index++] = key;
            }
        }

        return result;
    }

    /*
    Time Complexity: O(n)
    Space Complexity: O(n)
    */




    /*
    ============================================================
    APPROACH 2: Optimal (XOR Based)
    ------------------------------------------------------------
    INTUITION:
    1. XOR all numbers.
       Since duplicates cancel (a ^ a = 0),
       final xor = num1 ^ num2

    2. Find rightmost set bit in xor.
       This bit differs between num1 and num2.

    3. Divide numbers into two groups based on that bit.
       Duplicates fall into same group and cancel.
       Each group gives one unique number.
    ============================================================
    */

    public static int[] singleNumberOptimal(int[] nums) {

        int xor = 0;

        // Step 1: XOR all numbers
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Get rightmost set bit
        int diff = xor & (-xor);

        int num1 = 0;
        int num2 = 0;

        // Step 3: Divide into two groups
        for (int num : nums) {
            if ((num & diff) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }

    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
    */




    // ================= TESTING =================

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 2, 5};

        int[] brute = singleNumberBrute(nums);
        System.out.println("Brute: " + brute[0] + " " + brute[1]);

        int[] optimal = singleNumberOptimal(nums);
        System.out.println("Optimal: " + optimal[0] + " " + optimal[1]);
    }
}
