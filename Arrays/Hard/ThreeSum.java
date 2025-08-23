package Arrays.Hard;

import java.util.*;

public class ThreeSum {

    // -------------------------
    // BRUTE FORCE APPROACH
    // -------------------------
    /*
       Intuition:
       - Try all triplets (i, j, k) with 3 nested loops.
       - Check if their sum == 0.
       - Use a HashSet to store unique triplets (to avoid duplicates).
       - Complexity: O(n^3 * log m) where log m is sorting triplet before inserting.
       - Very slow for large n.
    */
    public List<List<Integer>> bruteThreeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> hs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // sort to handle duplicates
                        hs.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(hs);
    }

    // -------------------------
    // BETTER APPROACH (Hashing + 2Sum idea)
    // -------------------------
    /*
       Intuition:
       - Fix one number (nums[i]) and reduce problem to 2Sum:
         we need nums[j] + nums[k] = -nums[i].
       - Use a HashSet to check if complement exists.
       - Store valid triplets in a set to avoid duplicates.
       - Complexity: O(n^2 * log m) (log m from sorting triplet before insertion).
       - Better than brute, but still uses extra space.
    */
    public List<List<Integer>> betterThreeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> hs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int k = -(nums[i] + nums[j]);
                if (set.contains(k)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], k);
                    Collections.sort(triplet); // sort for uniqueness
                    hs.add(triplet);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(hs);
    }

    // -------------------------
    // OPTIMAL APPROACH (Sorting + 2 Pointers)
    // -------------------------
    /*
       Intuition:
       - Sort the array first.
       - Fix one number nums[i].
       - Then find 2 numbers such that nums[left] + nums[right] = -nums[i].
       - Use two pointers:
           if sum < 0 → move left++ (increase sum),
           if sum > 0 → move right-- (decrease sum),
           if sum == 0 → store triplet and skip duplicates.
       - Sorting helps avoid duplicates easily and enables 2-pointer technique.
       - Complexity: O(n^2)
         (sort O(n log n) + O(n^2) two-pointer search).
       - Space: O(1) (ignoring result storage).
    */
    public List<List<Integer>> optimalThreeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // sort first
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // need larger sum
                } else {
                    right--; // need smaller sum
                }
            }
        }
        return res;
    }
}
