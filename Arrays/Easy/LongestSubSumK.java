package Arrays.Easy;

import java.util.HashMap;

public class LongestSubSumK {

    /**
     * Brute Force Approach
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     * 
     * Intuition:
     * - Generate all possible subarrays using 3 loops.
     * - For each subarray, calculate sum and check if it's equal to k.
     */
    public static int BruteLongest(int[] a, int k) {
        int maxLen = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int sum = 0;
                for (int x = i; x <= j; x++) {
                    sum += a[x];
                }
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    /**
     * Better Approach
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * 
     * Intuition:
     * - Similar to brute force but optimizes inner loop by keeping a running sum.
     */
    public static int BetterLongest(int[] a, int k) {
        int maxLen = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    /**
     * Semi-Optimal Approach using HashMap (Prefix Sum)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * Intuition:
     * - Use a HashMap to store prefix sums and their first occurrence index.
     * - If (current prefix sum - k) exists in map, a subarray with sum k is found.
     * - Also check if prefix sum == k to cover subarrays starting from index 0.
     */
    public static int SemiOptimalLongest(int[] a, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            int rem = sum - k;
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // Store the first occurrence of the sum only
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    /**
     * Optimal Approach (Only for non-negative integers)
     * Time Complexity: O(2n) ~ O(n)
     * Space Complexity: O(1)
     * 
     * Intuition:
     * - Use a sliding window (two pointers) to find subarrays with sum = k.
     * - Only works for non-negative arrays, as increasing window always increases or keeps sum same.
     */
    public static int PositiveOptimalLongest(int[] a, int k) {
        int left = 0, right = 0, sum = a[0], maxLen = 0;

        while (right < a.length) {
            // Shrink window from the left if sum exceeds k
            while (sum > k && left <= right) {
                sum -= a[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Expand window to the right
            right++;
            if (right < a.length) {
                sum += a[right];
            }
        }
        return maxLen;
    }

    /**
     * Count all subarrays with sum = k (Leetcode 560)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * Intuition:
     * - Use HashMap to store prefix sum frequencies.
     * - If (currentSum - k) has occurred before, then add its count to total.
     */
//     Key: Integer → The prefix sum
// 📌 Value: Integer → The count (frequency) of how many times that prefix sum has occurred

    public static int CountAllSubarraysWithSumK(int[] a, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;

        map.put(0, 1); // To handle case when subarray starts from index 0

        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            int rem = sum - k;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
