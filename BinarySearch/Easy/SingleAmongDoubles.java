package Easy;

public class SingleAmongDoubles {

    /*
     * =============================
     * Problem:
     * You are given a sorted array where every element appears exactly twice 
     * except for one element which appears exactly once.
     * Your task is to find and return this single element.
     * =============================
     * Example:
     * nums = [1, 1, 2, 3, 3, 4, 4]
     * Output: 2
     */

    // -------------------------------------------------------------
    // 1. Optimized Approach (Binary Search) - O(log n) time
    // -------------------------------------------------------------
    /*
     * Intuition:
     *  - Since the array is sorted and elements appear in pairs,
     *    we can use binary search to quickly locate the single element.
     *  - Observation:
     *      Before the single element → first occurrence is at an even index
     *      After the single element  → first occurrence is at an odd index
     *  - Using this observation:
     *      1. Check special cases: single element is at index 0 or last index.
     *      2. Use binary search:
     *          - If mid is even and nums[mid] == nums[mid+1], single is to the right.
     *          - If mid is odd and nums[mid] == nums[mid-1], single is to the right.
     *          - Otherwise, it's to the left.
     *  - Repeat until low == high → nums[low] is the single element.
     */
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // Case when array has only one element
        if (n == 1) {
            return nums[0];
        }

        // Check if single element is at first index
        if (nums[0] != nums[1]) {
            return nums[0];
        }

        // Check if single element is at last index
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        // Binary search between index 1 and n-2
        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If mid is the single element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Decide which half to search
            if ((mid % 2 == 1 && nums[mid - 1] == nums[mid]) ||
                (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1; // Single is on the right
            } else {
                high = mid - 1; // Single is on the left
            }
        }

        return -1; // This should never be reached for valid input
    }

    // -------------------------------------------------------------
    // 2. Brute-force Approach - O(n) time
    // -------------------------------------------------------------
    /*
     * Intuition:
     *  - Just check every element against its neighbors.
     *  - If an element is different from both its previous and next elements,
     *    it must be the single one.
     *  - Special care for first and last element since they have only one neighbor.
     */
    public int BrutesingleNonDuplicate(int[] nums) {
        int n = nums.length;

        // Case when array has only one element
        if (n == 1) {
            return nums[0];
        }

        for (int i = 0; i < n; i++) {
            // If first element
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
            // If last element
            else if (i == n - 1) {
                if (nums[i] != nums[i - 1]) {
                    return nums[i];
                }
            }
            // If somewhere in the middle
            else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
        }

        return -1; // This should never be reached for valid input
    }

    // -------------------------------------------------------------
    // Main method for testing both approaches
    // -------------------------------------------------------------
    public static void main(String[] args) {
        SingleAmongDoubles obj = new SingleAmongDoubles();

        int[] nums = {1, 1, 2, 3, 3, 4, 4};

        System.out.println("Optimized (Binary Search) result: " + obj.singleNonDuplicate(nums));
        System.out.println("Brute-force result: " + obj.BrutesingleNonDuplicate(nums));
    }
}
