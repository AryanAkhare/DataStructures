package Arrays.Easy;

import static java.lang.Math.max;

// Problem: Find the maximum number of consecutive 1s in a binary array.
// Example: [1,1,0,1,1,1,0,1] → Output: 3
// Example: [1,1,0,1,0] → Output: 2

public class MaxConsec1 {
    public static int maxConsec1(int n[]) {
        int maxi = 0; // stores the maximum streak of 1s found so far
        int cnt = 0;  // counts the current streak of consecutive 1s

        for (int i = 0; i < n.length; i++) {
            if (n[i] == 1) {
                // if current element is 1 → increase current streak
                cnt++;
                // update maximum streak if current streak is greater
                maxi = max(maxi, cnt);
            } else {
                // if current element is 0 → streak breaks, reset counter
                cnt = 0;
            }
        }

        return maxi; // return the longest streak found
    }
}
