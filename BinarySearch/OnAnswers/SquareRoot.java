// Problem:
// Given a non-negative integer n, find and return the floor value of its square root.
// The floor of the square root is the greatest integer x such that x*x ≤ n.
// You must not use any built-in square root functions.

// Example:
// Input: n = 10
// Output: 3
// Explanation: √10 ≈ 3.16, so floor value is 3.

// Input: n = 16
// Output: 4

class Solution {
    int floorSqrt(int n) {

        // Binary search boundaries
        int low = 1;
        int high = n;

        // To store the final answer
        int ans = 0;

        // Binary search to find floor square root
        while (low <= high) {

            // Prevent overflow while finding mid
            int mid = low + (high - low) / 2;

            // Use long to avoid overflow when squaring
            long square = (long) mid * mid;

            // If mid^2 is less than or equal to n,
            // mid can be a possible answer
            if (square <= n) {
                ans = mid;          // update answer
                low = mid + 1;      // try for a bigger value
            } 
            // If mid^2 is greater than n,
            // discard right half
            else {
                high = mid - 1;
            }
        }

        // Final floor square root
        return ans;
    }
}
