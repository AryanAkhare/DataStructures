/*
LeetCode 930: Binary Subarrays With Sum

Problem Statement
-----------------
Given a binary array nums (contains only 0 and 1) and an integer goal,
return the number of non-empty subarrays with a sum equal to goal.

A subarray is a contiguous part of the array.

Example:
Input:
nums = [1,0,1,0,1], goal = 2

Output:
4

Explanation:
Subarrays with sum = 2:
[1,0,1]
[1,0,1,0]
[0,1,0,1]
[1,0,1]


------------------------------------------------------------
INTUITION
------------------------------------------------------------

Key Observation:
Since the array contains only 0s and 1s, we can use two techniques.

1) Prefix Sum + HashMap
2) Sliding Window (Optimal)

------------------------------------------------------------
APPROACH 1: Prefix Sum + HashMap
------------------------------------------------------------

Idea:
If

currentSum - previousSum = goal

then

previousSum = currentSum - goal

So we store how many times each prefix sum appeared.

Example:
nums = [1,0,1,0,1]
goal = 2

While iterating:
we check if (sum - goal) appeared before.

If yes:
all those occurrences form valid subarrays.

Time Complexity: O(n)
Space Complexity: O(n)

------------------------------------------------------------
APPROACH 2: Sliding Window (Optimal for Binary Arrays)
------------------------------------------------------------

Important Trick:

subarraysWithSum(goal) =
        subarraysWithSumAtMost(goal)
      - subarraysWithSumAtMost(goal - 1)

Why?

Because:
AtMost(goal) counts all subarrays with sum ≤ goal
AtMost(goal-1) counts all subarrays with sum ≤ goal-1

Subtracting them gives exactly sum == goal.

Sliding Window works here because
numbers are only 0 and 1 (sum grows predictably).

Time Complexity: O(n)
Space Complexity: O(1)

------------------------------------------------------------
*/

import java.util.HashMap;

class Solution {

    /*
    ------------------------------------------------------------
    METHOD 1: Prefix Sum + HashMap
    ------------------------------------------------------------
    */
    public int numSubarraysWithSumPrefix(int[] nums, int goal) {

        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        int count = 0;
        int sum = 0;

        // base case: sum 0 occurs once
        prefixSum.put(0, 1);

        for (int x : nums) {

            sum += x;

            // check if (sum - goal) existed before
            if (prefixSum.containsKey(sum - goal)) {
                count += prefixSum.get(sum - goal);
            }

            // store current prefix sum
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }


    /*
    ------------------------------------------------------------
    METHOD 2: Optimal Sliding Window
    ------------------------------------------------------------
    */
    public int numSubarraysWithSum(int[] nums, int goal) {

        // exactly goal = atMost(goal) - atMost(goal-1)
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }


    /*
    Helper function to count subarrays with sum <= goal
    */
    private int atMost(int[] nums, int goal) {

        if (goal < 0) return 0;

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            // shrink window if sum exceeds goal
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            /*
            All subarrays ending at 'right' with start from
            left to right are valid.

            number of subarrays = window size
            */
            count += right - left + 1;
        }

        return count;
    }
}