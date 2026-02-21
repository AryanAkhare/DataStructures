package TwoPointers.Medium;

import java.util.*;

public class MaxConsec1s3 {

    /*
    ================================================================
    PROBLEM 1: Max Consecutive Ones (LeetCode 485)
    ------------------------------------------------
    Given a binary array nums, return the maximum number of 
    consecutive 1's in the array.

    Example:
    Input: [1,1,0,1,1,1]
    Output: 3

    INTUITION:
    - Traverse array
    - Count consecutive 1s
    - Reset count when 0 appears
    - Track maximum

    TIME COMPLEXITY: O(n)
    SPACE COMPLEXITY: O(1)
    ================================================================
    */

    public static int maxConsec1(int[] nums) {

        int max = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }

        return max;
    }


    /*
    ================================================================
    PROBLEM 2: Max Consecutive Ones III (LeetCode 1004)
    ------------------------------------------------
    Given a binary array nums and an integer k,
    return the maximum number of consecutive 1's
    if you can flip at most k zeros.

    Example:
    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    Output: 6

    ================================================================
    BRUTE FORCE APPROACH
    ------------------------------------------------
    INTUITION:
    - For every starting index i
    - Expand window using j
    - Count zeros
    - If zeros > k → stop
    - Track max length

    TIME COMPLEXITY: O(n^2)
    SPACE COMPLEXITY: O(1)
    ================================================================
    */

    public static int longestOnesBrute(int[] nums, int k) {

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            int zeroCount = 0;

            for (int j = i; j < nums.length; j++) {

                if (nums[j] == 0) zeroCount++;

                if (zeroCount > k) break;

                max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }


    /*
    ================================================================
    OPTIMAL APPROACH (Sliding Window)
    ------------------------------------------------
    INTUITION:
    - Use two pointers (left & right)
    - Expand right
    - Count zeros
    - If zeros > k → shrink from left
    - Always maintain valid window

    WHY IT WORKS:
    - Each element enters window once
    - Each element leaves window once
    - No reprocessing

    TIME COMPLEXITY: O(n)
    SPACE COMPLEXITY: O(1)
    ================================================================
    */

    public static int longestOnesOptimal(int[] nums, int k) {

        int left = 0;
        int zeroCount = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) zeroCount++;

            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

}