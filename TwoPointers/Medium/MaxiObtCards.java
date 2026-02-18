package TwoPointers.Medium;

/*
Problem:
You are given an array of integers representing card points.
You can pick exactly k cards from either the beginning or the end.
Return the maximum score you can obtain.

Intuition:
If we pick k cards from the ends, the total picks must be:
(i cards from left) + (k - i cards from right)

Instead of trying all combinations with nested loops,
we:

1. First take first k elements from left.
2. Then gradually:
   - Remove one element from left sum
   - Add one element from right sum
   - Update maximum

This efficiently checks all valid splits:
(k,0), (k-1,1), (k-2,2), ..., (0,k)
*/

public class MaxiObtCards {

    public static int maxScore(int[] arr, int k) {

        int n = arr.length;

        int lsum = 0;   // sum from left
        int rsum = 0;   // sum from right

        // Step 1: Take first k elements from left
        for (int i = 0; i < k; i++) {
            lsum += arr[i];
        }

        int maxSum = lsum;

        int r = n - 1;

        // Step 2: Shift picks from left to right
        for (int i = k - 1; i >= 0; i--) {

            lsum -= arr[i];      // remove from left
            rsum += arr[r];      // add from right
            r--;

            maxSum = Math.max(maxSum, lsum + rsum);
        }

        return maxSum;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        System.out.println("Maximum Score: " + maxScore(arr, k));
    }
}

/*
Time Complexity:
O(k)

Why?
- First loop runs k times
- Second loop runs k times
Total = O(2k) ≈ O(k)

Space Complexity:
O(1)

We only use variables, no extra data structures.
*/
