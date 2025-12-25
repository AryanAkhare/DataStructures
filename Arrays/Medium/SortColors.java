package Arrays;

import java.util.Arrays;

/*
 * LeetCode Problem 75: Sort Colors
 *
 * Problem Statement:
 * ------------------
 * Given an array 'nums' containing 0s (red), 1s (white), and 2s (blue),
 * sort them in-place so that objects of the same color are adjacent and appear
 * in the order: red (0), white (1), blue (2).
 *
 * Constraints:
 * - Do not use library sort.
 * - Must sort in-place (O(1) extra space).
 */

public class SortColors {

    // 💡 Better approach using counting sort (2-pass, O(2N))
    public static int[] betterColorSort(int[] nums) {
        int count0 = 0;
        int count1 = 0;

        // Count the number of 0s and 1s
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++;
            else if (nums[i] == 1) count1++;
        }

        // Fill array: first 0s, then 1s, then remaining 2s
        for (int i = 0; i < count0; i++) nums[i] = 0;
        for (int i = count0; i < count0 + count1; i++) nums[i] = 1;
        for (int i = count0 + count1; i < nums.length; i++) nums[i] = 2;

        return nums;
    }

    // 🔁 Helper swap function
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ✅ Optimal approach using Dutch National Flag algorithm (1-pass, O(N), O(1) space)
    public static int[] optimalColorSort(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        /*
         * Intuition (Dutch National Flag):
         * We maintain 3 partitions:
         * - [0...low-1] → All 0s (red)
         * - [low...mid-1] → All 1s (white)
         * - [high+1...end] → All 2s (blue)
         * 
         * At any point:
         * mid → current element we're checking
         *
         * Start with:
         * [2, 0, 1, 2, 1, 0, 0, 0, 1, 2]
         *  ↑   ↑               ↑
         * low mid            high
         */

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap current 0 to front partition
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 is already in the right place
                mid++;
            } else {
                // Swap 2 to the end partition
                swap(nums, mid, high);
                high--;
                // Don't increment mid here because the swapped element needs to be checked
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int arr[] = {2, 0, 1, 2, 1, 0, 0, 0, 1, 2};
        
        // 🧪 Test optimal one-pass DNF sort
        int b[] = optimalColorSort(arr);
        
        // ✅ Output: should be sorted in [0,0,0,0,1,1,1,2,2,2] order
        System.out.println(Arrays.toString(b));
    }
}
