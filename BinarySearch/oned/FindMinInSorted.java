package oned;
/**
 * Problem 1: Find Minimum in Rotated Sorted Array
 * -----------------------------------------------
 * Given a rotated sorted array without duplicates, find the minimum element.
 * 
 * Example:
 * Input:  [4,5,6,7,0,1,2]
 * Output: 0
 * 
 * Intuition:
 * - The minimum element will be in the unsorted half.
 * - Use binary search:
 *   1. If left half is sorted, the smallest element in it is at nums[low].
 *   2. If right half is sorted, the smallest element is at nums[mid].
 * - Keep updating the answer and moving to the unsorted half.
 */
public class FindMinInSorted {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If left half is sorted
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]); // smallest in left half
                low = mid + 1; // move to right half
            }
            // If right half is sorted
            else {
                ans = Math.min(ans, nums[mid]); // smallest in right half
                high = mid - 1; // move to left half
            }
        }

        return ans;
    }
}

/**
 * Problem 2: Find Rotation Count of Sorted Array
 * -----------------------------------------------
 * Given a rotated sorted array without duplicates, find the number of times 
 * it has been rotated. This is equal to the index of the minimum element.
 * 
 * Example:
 * Input:  [4,5,6,7,0,1,2]
 * Output: 4
 * 
 * Intuition:
 * - The smallest element marks the rotation count.
 * - If the current segment is already sorted, smallest is at low.
 * - Otherwise, move towards the unsorted half where the smallest element lies.
 */
class Solution {
    public int findKRotation(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            // If segment is already sorted
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                break;
            }

            int mid = low + (high - low) / 2;

            // If left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                low = mid + 1;
            }
            // If right half is sorted
            else {
                if (arr[mid] < ans) {
                    ans = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }

        return index; // rotation count
    }
}
