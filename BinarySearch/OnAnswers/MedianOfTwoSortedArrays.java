/*
Problem: Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, 
return the median of the two sorted arrays.

- Median: the middle value in the combined sorted array if odd length, 
  or the average of the two middle values if even length.
- Arrays are sorted individually but not merged.
- Goal: Find median in **O(log(min(m, n)))** time.

Example:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.0
Explanation: Combined array = [1,2,3], median = 2

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.5
Explanation: Combined array = [1,2,3,4], median = (2+3)/2 = 2.5

---

Brute Force Approach:
1. Merge both arrays into a single sorted array (like your code does)
2. Find the median from the merged array
- Time Complexity: O(m + n) (because of merging)
- Space Complexity: O(m + n) (storing merged array)
- Limitation: Not optimal for large arrays

Better Approach (without extra space):
1. Use two pointers to traverse both arrays as if merging, 
   but **only track elements around the median position**.
2. No need to store full array.
- Time Complexity: O(m + n)
- Space Complexity: O(1)
- Still not optimal if arrays are very large

Optimal Approach (Binary Search):
1. Observe that median splits combined array into two halves:
   - Left half <= Right half
2. Use binary search on the smaller array to find a partition index `i` such that:
   - nums1[i-1] <= nums2[j] and nums2[j-1] <= nums1[i], where j = (m+n+1)/2 - i
3. Median is max(left half) or average of max(left half) and min(right half)
4. Key idea: exploit **sorted property + partitioning**.
- Time Complexity: O(log(min(m, n)))
- Space Complexity: O(1)

Intuition:
- Instead of fully merging arrays, find the "cut" where left side of combined arrays
  contains exactly half of elements.
- Binary search helps efficiently find this cut in the smaller array.

References:
- LeetCode 4: https://leetcode.com/problems/median-of-two-sorted-arrays/
*/

package OnAnswers;

import java.util.*;

public class MedianOfTwoSortedArrays {

    // ------------------- 1. Brute Force Approach -------------------
    // Merge both arrays into a new array, then find median.
    // Time: O(m+n), Space: O(m+n)
    public static double findMedianBruteForce(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;
        ArrayList<Integer> merged = new ArrayList<>();

        int i = 0, j = 0;
        // Merge arrays
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) merged.add(nums1[i++]);
            else merged.add(nums2[j++]);
        }
        while (i < n1) merged.add(nums1[i++]);
        while (j < n2) merged.add(nums2[j++]);

        // Find median
        if (n % 2 == 1) return merged.get(n / 2);
        return (merged.get(n / 2 - 1) + merged.get(n / 2)) / 2.0;
    }

    // ------------------- 2. Better Approach -------------------
    // Use two pointers, track median elements without extra space.
    // Time: O(m+n), Space: O(1)
    public static double findMedianTwoPointers(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;
        int i = 0, j = 0;
        int prev = 0, curr = 0; // store last two elements for median

        for (int count = 0; count <= n / 2; count++) {
            prev = curr;
            if (i < n1 && (j >= n2 || nums1[i] <= nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
        }

        if (n % 2 == 1) return curr;                 // odd length → middle element
        return (prev + curr) / 2.0;                  // even length → average of two middle
    }

    // ------------------- 3. Optimal Approach (Binary Search) -------------------
    // Use binary search on smaller array to find correct partition.
    // Time: O(log(min(m,n))), Space: O(1)
    public static double findMedianOptimal(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianOptimal(nums2, nums1); // ensure nums1 smaller

        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int i = (low + high) / 2;                  // partition index in nums1
            int j = (m + n + 1) / 2 - i;              // partition index in nums2

            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Correct partition found
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                high = i - 1; // move left in nums1
            } else {
                low = i + 1;  // move right in nums1
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted properly.");
    }

    // ------------------- Main -------------------
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println("Brute Force Median: " + findMedianBruteForce(nums1, nums2));
        System.out.println("Two Pointers Median: " + findMedianTwoPointers(nums1, nums2));
        System.out.println("Optimal Median: " + findMedianOptimal(nums1, nums2));
    }
}
