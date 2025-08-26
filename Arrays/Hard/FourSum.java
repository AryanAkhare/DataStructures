package Arrays.Hard;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class FourSum {

    /*
     * Problem Intuition:
     * -----------------
     * Given an integer array `nums` and a target value `target`, we need to find
     * all unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     *   1. a, b, c, d are distinct indices
     *   2. nums[a] + nums[b] + nums[c] + nums[d] == target
     *
     * The main challenge is:
     * - Avoiding duplicate quadruplets
     * - Efficiently finding combinations without using O(n^4) brute force
     *
     * Approach:
     * --------
     * 1. Sort the array to make duplicate handling easier and enable two-pointer technique.
     * 2. Use two nested loops for the first two numbers (`i` and `j`) and
     *    two pointers (`p` and `q`) for the remaining two numbers.
     * 3. For each pair (i, j), set `p = j+1` and `q = n-1`. Move the pointers based on sum:
     *    - If sum < target, increment `p` to increase sum
     *    - If sum > target, decrement `q` to decrease sum
     *    - If sum == target, store quadruplet and skip duplicates
     * 4. Skip duplicates for `i`, `j`, `p`, and `q` to ensure uniqueness.
     *
     * Time Complexity (TC):
     * --------------------
     * Sorting: O(n log n)
     * Two nested loops (i, j) + two pointers (p, q) inside => O(n^3)
     * Overall TC: O(n^3)
     *
     * Space Complexity (SC):
     * ---------------------
     * O(1) extra space (ignoring output list) since we only use pointers and loops
     * Output list may contain up to O(n^4) quadruplets in worst case
     */

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        // Step 1: Sort array for two-pointer technique and easier duplicate handling
        Arrays.sort(nums);

        // Step 2: Loop for the first number
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates for i

            // Step 3: Loop for the second number
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates for j

                int p = j + 1;   // third pointer
                int q = n - 1;   // fourth pointer

                // Step 4: Two-pointer approach for remaining two numbers
                while (p < q) {
                    long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];

                    if (sum < target) p++;     // need a larger sum
                    else if (sum > target) q--; // need a smaller sum
                    else {
                        // Found a quadruplet
                        ans.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));

                        // Skip duplicates for third and fourth numbers
                        while (p < q && nums[p] == nums[p + 1]) p++;
                        while (p < q && nums[q] == nums[q - 1]) q--;

                        // Move both pointers after storing valid quadruplet
                        p++;
                        q--;
                    }
                }
            }
        }
        return ans;
    }
}
