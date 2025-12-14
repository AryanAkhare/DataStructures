package OneD;

import java.util.ArrayList;

public class FirstandLastOccurence {

    /*
     * Brute force approach:
     * Traverse from start to find first occurrence,
     * Traverse from end to find last occurrence.
     * Time Complexity: O(n)
     */
    ArrayList<Integer> find(int arr[], int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1); // first occurrence
        ans.add(-1); // last occurrence

        int n = arr.length;

        // Find first occurrence by scanning from left
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                ans.set(0, i);
                break;
            }
        }

        // Find last occurrence by scanning from right
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == x) {
                ans.set(1, i);
                break;
            }
        }

        return ans;
    }

    /*
     * Binary Search approach:
     * lowerBound() finds the first index where arr[index] >= x.
     * upperBound() finds the first index where arr[index] > x.
     *
     * Using these:
     * - If arr[lowerBound] != target or lowerBound is out of range, target not present.
     * - Else, first occurrence = lowerBound
     * - Last occurrence = upperBound - 1
     *
     * Time Complexity: O(log n)
     */

    public static int lowerBound(int[] arr, int x) {
        int ans = arr.length;   // Default answer if x is greater than all elements
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                // Mid could be the lower bound
                ans = mid;
                high = mid - 1;  // Look on the left side to find smaller index
            } else {
                low = mid + 1;   // x must be on the right side
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int x) {
        int ans = arr.length;   // Default answer if x is greater or equal to all elements
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x) {
                // Mid could be the upper bound
                ans = mid;
                high = mid - 1;  // Look on the left side
            } else {
                low = mid + 1;   // x or smaller values are on left; move right
            }
        }
        return ans;
    }

    public static int[] findOccurenceBinarySearch(int[] arr, int target) {
        int lb = lowerBound(arr, target);
        int ub = upperBound(arr, target);

        // If lower bound is out of range or arr[lb] != target, target not found
        if (lb == arr.length || arr[lb] != target) {
            return new int[] { -1, -1 };
        }

        // Return first and last occurrence indices
        return new int[] { lb, ub - 1 };
    }
}
