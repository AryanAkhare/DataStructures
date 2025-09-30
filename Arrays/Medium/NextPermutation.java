package Arrays;
import java.util.*;

/**
 * Next Permutation implementation with execution example and detailed intuition in comments.
 *
 * Intuition:
 * 1. Starting from the end, find the first position (pivot) where nums[i] < nums[i+1]. This identifies the
 *    longest non-increasing suffix. The prefix before pivot can be increased to get the next permutation.
 * 2. If no such pivot exists, the entire array is in descending order; reverse it to get the lowest order.
 * 3. Otherwise, from the end again, find the first element greater than nums[pivot] (the successor), swap them.
 * 4. Finally, reverse the suffix after pivot to turn it into the smallest possible order, completing the next lexicographical permutation.
 *
 * Example flow for [1,2,3,6,5,4]:
 * - Suffix is [6,5,4] (non-increasing), pivot is 2 (value 3).
 * - Successor is 4 (value 4) at end; swap -> [1,2,4,6,5,3]
 * - Reverse suffix after pivot: [1,2,4,3,5,6] which is next permutation.
 */
public class NextPermutation {
    /**
     * Swaps two elements in the array.
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Reverses the subarray nums[start..end] in place using a for-style loop (while loop here for clarity).
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    /**
     * Transforms nums into its next lexicographical permutation in place.
     * If no such permutation exists, rearranges to the lowest possible order.
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        // Step 1: find pivot where nums[i] < nums[i+1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        // If no pivot, just reverse whole array
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        // Step 2: find the rightmost successor greater than pivot
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, pivot, i);
                break;
            }
        }
        // Step 3: reverse suffix after pivot to get the minimum arrangement
        reverse(nums, pivot + 1, n - 1);
    }

    // Utility to print array
    private static String arrayToString(int[] arr) {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        NextPermutation solver = new NextPermutation();
        int[][] tests = {
            {1, 2, 3},
            {2, 3, 1},
            {3, 2, 1},
            {1, 2, 3, 6, 5, 4},
            {1, 1, 5},
            {1},
            {1, 5, 4, 3, 2}
        };
        for (int[] test : tests) {
            int[] copy = Arrays.copyOf(test, test.length);
            System.out.println("Input: " + arrayToString(copy));
            solver.nextPermutation(copy);
            System.out.println("Next Permutation: " + arrayToString(copy));
            System.out.println();
        }
    }
}
