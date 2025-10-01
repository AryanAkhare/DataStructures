package Arrays.Easy;

import java.util.ArrayList;

/**
 * Problem Statement:
 * Given an array `nums` of even length consisting of an equal number of positive and negative integers,
 * rearrange the array so that positive and negative numbers alternate.
 * The order of elements within the positive and negative numbers should be preserved.
 *
 * Example:
 * Input: nums = [3,1,-2,-5,2,-4]
 * Output: [3,-2,1,-5,2,-4]
 *
 * Constraints:
 * - Array length is even
 * - Same number of positive and negative integers
 *
 * Intuition:
 * Since the count of positives and negatives is the same and the length is even,
 * we can assign every even index with a positive and every odd index with a negative.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class RearrangePosAndNeg {

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int pos = 0;
        int neg = 1;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                result[neg] = nums[i];
                neg += 2;
            } else {
                result[pos] = nums[i];
                pos += 2;
            }
        }
        return result;
    }

    // Variant when positives and negatives are not in equal count
    // This is a brute-force approach that tries to interleave as much as possible
    public static int[] rearrangeArrayVariety(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) pos.add(num);
            else neg.add(num);
        }

       
        int i = 0, p = 0, ng = 0;
        while (p < pos.size() && ng < neg.size()) {
            nums[i++] = pos.get(p++);
            nums[i++] = neg.get(ng++);
        }

        // Add remaining positives
        while (p < pos.size()) {
            nums[i++] = pos.get(p++);
        }

        // Add remaining negatives
        while (ng < neg.size()) {
            nums[i++] = neg.get(ng++);
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, -2, -5, 2, -4};
        int[] nums = rearrangeArray(a);

        for (int x : nums) {
            System.out.println(x);
        }

        // Uncomment to test with unequal positive and negative counts
        // int[] b = {3, -2, 5, -1, -7};
        // int[] rearranged = rearrangeArrayVariety(b);
        // for (int x : rearranged) {
        //     System.out.print(x + " ");
        // }
    }
}
