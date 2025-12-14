// Problem: Peak Element(s) in an Array
// --------------------------------------
// You are given an array arr[] where no two adjacent elements are same.
// 1) Find all peaks (indices where nums[i] > nums[i-1] && nums[i] > nums[i+1]).
// 2) Find any one peak element index efficiently (binary search).
//
// Note:
// - First and last elements cannot be considered peaks for part (1).
// - For part (2), assume arr[-1] = arr[n] = -∞ (so boundaries can also be peaks).
//
// Example 1:
// Input: arr = [1, 2, 4, 5, 7, 8, 3]
// Output: true (index 5 -> value 8 is a peak)
//
// Example 2:
// Input: arr = [10, 20, 15, 2, 23, 90, 80]
// Output: true (index 1 -> value 20 or index 5 -> value 90)
//
// --------------------------------------
package OneD;
import java.util.*;

public class PeakElement {

    // ---------------------------------------------------
    // Part 1: Find all peak indices (O(n))
    // ---------------------------------------------------
    // Intuition:
    // - Loop through array from 1 to n-2 (skip boundaries).
    // - A peak is when nums[i] > nums[i-1] && nums[i] > nums[i+1].
    // ---------------------------------------------------
    // Time Complexity: O(n)
    // Space Complexity: O(k) where k = number of peaks (list to store indices)
    public List<Integer> findPeaks(int[] nums) {
        List<Integer> peaks = new ArrayList<>();
        int n = nums.length;

        for (int i = 1; i < n - 1; i++) { // skip first and last
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peaks.add(i);
            }
        }
        return peaks;
    }

    // ---------------------------------------------------
    // Part 2: Find one peak index using Binary Search (O(log n))
    // ---------------------------------------------------
    // Intuition:
    // - Use binary search to find a peak.
    // - If arr[mid] < arr[mid+1], then a peak lies on the right side.
    // - Otherwise, peak lies at mid or to the left.
    // - Eventually, low == high points to a peak.
    // ---------------------------------------------------
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public int findPeakElement(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;  // peak on right
            } else {
                high = mid;     // peak at mid or left
            }
        }
        return low; // or high, both are same here
    }

    // ---------------------------------------------------
    // Driver code (for testing)
    // ---------------------------------------------------
    public static void main(String[] args) {
        PeakElement obj = new PeakElement();

        int[] arr1 = {1, 2, 4, 5, 7, 8, 3};
        int[] arr2 = {10, 20, 15, 2, 23, 90, 80};

        System.out.println("All peaks in arr1: " + obj.findPeaks(arr1));
        System.out.println("Any one peak in arr1: index " + obj.findPeakElement(arr1));

        System.out.println("All peaks in arr2: " + obj.findPeaks(arr2));
        System.out.println("Any one peak in arr2: index " + obj.findPeakElement(arr2));
    }
}
