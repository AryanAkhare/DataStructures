import java.util.*;

/*
Intuition:
- For a set of size n, total possible subsets = 2^n.
- Each subset can be represented using a binary number (bitmask).
- If n = 3, total subsets = 2^3 = 8
  Example:
    nums = [1,2,3]

    mask (binary)   subset
    000             []
    001             [1]
    010             [2]
    011             [1,2]
    100             [3]
    101             [1,3]
    110             [2,3]
    111             [1,2,3]

- If jth bit in mask is ON, include nums[j] in subset.
- We loop mask from 0 to (2^n - 1) and build subsets.

Time Complexity (TC):
- Outer loop runs 2^n times.
- Inner loop runs n times.
- Total = O(n * 2^n)

Space Complexity (SC):
- We store 2^n subsets.
- Each subset can take up to n space.
- Total space = O(n * 2^n)
- Extra space (excluding output) = O(n) for temporary subset.
*/

public class PowSet {

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {

            int n = nums.length;
            int total = 1 << n;   // 2^n

            List<List<Integer>> result = new ArrayList<>();

            for (int mask = 0; mask < total; mask++) {

                List<Integer> subset = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    if ((mask & (1 << j)) != 0) {
                        subset.add(nums[j]);
                    }
                }

                result.add(subset);
            }

            return result;
        }
    }
}
