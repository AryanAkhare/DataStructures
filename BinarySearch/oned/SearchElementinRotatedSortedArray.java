package OneD;

public class SearchElementinRotatedSortedArray {
    /*
     * Problem:
     * You are given a rotated sorted array (without duplicates) and a target value.
     * The task is to return the index of the target if found, otherwise return -1.
     *
     * Example:
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     *
     * Explanation:
     * The array is sorted but rotated at some pivot. We need to find the element efficiently.
     */

    /*
     * Intuition:
     * A rotated sorted array can be divided into two sorted halves:
     *   - One half is always sorted (either left or right).
     *   - We use Binary Search to decide in which half the target lies.
     *   - This gives us O(log n) time complexity.
     *
     * Steps:
     * 1. Calculate mid.
     * 2. If nums[mid] == target → return mid.
     * 3. If left half is sorted:
     *      - Check if target lies in left half → search left.
     *      - Else → search right.
     * 4. Else (right half is sorted):
     *      - Check if target lies in right half → search right.
     *      - Else → search left.
     * 5. Repeat until low > high.
     */

    // Brute force method: O(n) time
    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i; // Found target
            }
        }
        return -1; // Not found
    }

    // Optimal method: O(log n) time using binary search
    public static int searchBinary(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Found target
            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Search in left half
                } else {
                    low = mid + 1;  // Search in right half
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // Search in right half
                } else {
                    high = mid - 1; // Search in left half
                }
            }
        }
        return -1; // Not found
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        // Testing brute force method
        int indexBrute = search(nums, target);
        System.out.println("Brute Force: Target found at index = " + indexBrute);

        // Testing binary search method
        int indexBinary = searchBinary(nums, target);
        System.out.println("Binary Search: Target found at index = " + indexBinary);
    }
}
