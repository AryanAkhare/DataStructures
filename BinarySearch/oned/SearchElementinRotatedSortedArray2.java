package OneD;
public class SearchElementinRotatedSortedArray2 {

    /*
     * Problem:
     * Given a rotated sorted array nums (possibly containing duplicates) and a target value,
     * return true if target exists in the array, otherwise return false.
     *
     * Condition Difference from Normal Version:
     * In the normal version (Search in Rotated Sorted Array I), the array has no duplicates.
     * In this version, duplicates are allowed, which can make it harder to decide
     * which side of the array is sorted. This is why we add extra logic to handle cases
     * where nums[low], nums[mid], and nums[high] are all equal.
     *
     * Example:
     * Input: nums = [2,5,6,0,0,1,2], target = 0
     * Output: true
     *
     * Input: nums = [1,1,1,3,1], target = 3
     * Output: true
     */

    /*
     * Intuition:
     * - Normally, in a rotated sorted array, one half is always sorted.
     * - With duplicates, nums[low] == nums[mid] == nums[high] can happen, which makes it impossible
     *   to tell which half is sorted just by comparing.
     * - In such cases, we simply shrink the search space by doing low++ and high--.
     * - Otherwise, we follow the same binary search logic:
     *      1. Check if nums[mid] is target.
     *      2. If left half is sorted, decide if target lies in it.
     *      3. Else, right half is sorted, decide accordingly.
     */

    public static boolean searchBool(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Found target
            if (nums[mid] == target) return true;

            // Handle duplicates
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue; // Skip to next iteration
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Search left
                } else {
                    low = mid + 1;  // Search right
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // Search right
                } else {
                    high = mid - 1; // Search left
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example 1 - Target present
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0;
        System.out.println("Example 1: " + searchBool(nums1, target1)); // true

        // Example 2 - Target not present
        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        int target2 = 3;
        System.out.println("Example 2: " + searchBool(nums2, target2)); // false

        // Example 3 - With many duplicates
        int[] nums3 = {1, 1, 1, 3, 1};
        int target3 = 3;
        System.out.println("Example 3: " + searchBool(nums3, target3)); // true
    }
}
