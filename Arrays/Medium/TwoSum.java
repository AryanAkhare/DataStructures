package Arrays;
// 1. Two Sum

import java.util.HashMap;
import java.util.Arrays;

/*
Given an array of integers nums and an integer target, return indices of the two numbers
such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
*/

public class TwoSum {

    // Brute Force Approach
    /*
    Intuition:
    Simply check every possible pair in the array to see if the sum equals the target.
    Time Complexity: O(n^2)
    Space Complexity: O(1)
    */
    public static int[] BrutetwoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // skip same index
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // if no pair is found
    }

    // Better Approach using HashMap
    /*
    Intuition:
    We traverse the array and store each element's value and index in a hashmap.
    For each element, we calculate the complement (target - current number).
    If the complement exists in the map, we found the pair.

    This avoids the inner loop and improves time complexity to O(n).
    Time Complexity: O(n)
    Space Complexity: O(n)
    */
    public static int[] BettertwoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(); // stores num -> index
        for (int i = 0; i < n; i++) {
            int com = target - nums[i]; // complement to find
            if (map.containsKey(com)) {
                // Found the two numbers: nums[i] + nums[j] = target
                return new int[]{map.get(com), i};
            }
            map.put(nums[i], i); // store current num with its index
        }
        return new int[]{-1, -1}; // if no pair is found
    }

    // Optimal Approach: Two Pointers (only for checking if sum exists)
    /*
    Intuition:
    Sort the array and use two pointers: one at the start and one at the end.
    Move pointers based on the sum:
    - If sum < target, move left pointer to right
    - If sum > target, move right pointer to left
    - If sum == target, return true

    This does not preserve indices, as sorting changes them.
    Time Complexity: O(n log n) due to sorting
    Space Complexity: O(1) if sorting in-place
    */
    public static boolean istwoSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // sort array to apply two-pointer
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return true; // pair found
            }
            if (sum < target) {
                left++; // increase sum
            } else {
                right--; // decrease sum
            }
        }
        return false; // no such pair exists
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};

        int b[] = BettertwoSum(arr, 7);
        for (int x : b) {
            System.out.println(x);
        }

        System.out.println(istwoSum(arr, 7)); // true
    }
}
