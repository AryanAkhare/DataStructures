package MaximizeMinAndViceVersa;

import java.util.Arrays;

/**
 * Problem: Aggressive Cows
 * ----------------------------------
 * You are given an array of stall positions (stalls[]) where each element 
 * represents the position of a stall on a line. You are also given an integer cows, 
 * which represents the number of cows to place.
 * 
 * Goal:
 * Place the cows in stalls such that the minimum distance between any two cows is maximized.
 *
 * Example:
 * stalls = [1, 2, 4, 8, 9], cows = 3
 * Optimal placement: cows at stalls 1, 4, 9 → minimum distance = 3
 * Answer = 3
 *
 * ------------------------------
 * Intuition:
 * ------------------------------
 * - The "answer" is the minimum distance between cows, which we want to maximize.
 * - Brute Force: Try every distance from 1 to (max - min) and check feasibility using `possibleCows`.
 * - Optimized: Use Binary Search on the distance.
 *   - Low = 1 (minimum possible distance).
 *   - High = max - min (largest possible distance).
 *   - Check mid distance:
 *       - If placement is possible → try bigger distance (move right).
 *       - Else → try smaller distance (move left).
 *   - This way, we efficiently find the maximum possible minimum distance.
 *
 * ------------------------------
 * Time Complexity:
 * ------------------------------
 * Brute Force:
 *   - O((max-min) * n)
 *   - For each possible distance, we check feasibility in O(n).
 *
 * Optimized (Binary Search):
 *   - O(n log(max-min))
 *   - Sorting stalls → O(n log n)
 *   - Binary search over distance (log(max-min)) 
 *     and each check is O(n).
 *
 * ------------------------------
 * Space Complexity: O(1)
 * ------------------------------
 * No extra space apart from a few variables.
 */

class AggresiveCows {

    // Brute force approach
    public int aggresiveCowsBrute(int stalls[], int cows) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int min = stalls[0];
        int max = stalls[n - 1];

        for (int i = 1; i <= max - min; i++) {
            if (!possibleCows(stalls, i, cows)) {
                return i - 1; // previous distance was the maximum valid
            }
        }
        return max - min;
    }

    // Optimized binary search approach
    public int optimizedAggresiveCow(int stalls[], int cows) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int min = stalls[0];
        int max = stalls[n - 1];
        int ans = 0;

        int low = 1;
        int high = max - min;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possibleCows(stalls, mid, cows)) {
                ans = mid;       // mid works, try bigger distance
                low = mid + 1;
            } else {
                high = mid - 1;  // mid doesn't work, try smaller distance
            }
        }
        return ans;
    }

    // Helper function to check if cows can be placed with given minimum distance
    public boolean possibleCows(int arr[], int distance, int cows) {
        int count = 1;   // place first cow at arr[0]
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= distance) {
                count++;
                last = arr[i];
            }
            if (count >= cows) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        AggresiveCows ac = new AggresiveCows();
        int[] stalls = {1, 2, 4, 8, 9};
        int cows = 3;

        System.out.println("Brute Force Result: " + ac.aggresiveCowsBrute(stalls, cows));
        System.out.println("Optimized Result: " + ac.optimizedAggresiveCow(stalls, cows));
    }
}
