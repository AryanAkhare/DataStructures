

/*
Question:
-----------
A conveyor belt has packages that must be shipped within 'days' days.
The ith package has a weight of weights[i]. Each day, the ship can carry packages 
with a maximum capacity of 'cap'. The ship must carry packages in the given order. 

Return the minimum ship capacity to ship all packages within the given 'days'.

Example:
---------
Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15

Explanation: 
A ship capacity of 15 is the minimum to ship within 5 days:
Day 1: 1,2,3,4,5 
Day 2: 6,7 
Day 3: 8 
Day 4: 9 
Day 5: 10

---------------------------------------------------------------
Complexity Intuition:
---------------------
- We binary search between max(weights) and sum(weights) → O(log(sum(weights))).
- For each mid (capacity), we check how many days are needed (linear scan of weights) → O(n).
- Total Time Complexity: O(n * log(sum(weights))).
- Space Complexity: O(1) (only variables, no extra data structures).
---------------------------------------------------------------
*/

public class CapToShipInDdays {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int low = max(weights);      // minimum possible capacity (heaviest package)
            int high = sum(weights);     // maximum possible capacity (carry all at once)

            while (low <= high) {
                int mid = low + (high - low) / 2;
                int numDays = findDays(weights, mid);

                if (numDays <= days) {
                    high = mid - 1;  // try smaller capacity
                } else {
                    low = mid + 1;   // need bigger capacity
                }
            }
            return low;
        }

        // Function to calculate days needed with given ship capacity
        public int findDays(int[] weights, int cap) {
            int days = 1, load = 0;
            for (int w : weights) {
                if (load + w > cap) {
                    days++;
                    load = w;  // start next day
                } else {
                    load += w;
                }
            }
            return days;
        }

        // Helper function: sum of array
        public int sum(int[] arr) {
            int sum = 0;
            for (int x : arr) sum += x;
            return sum;
        }

        // Helper function: max element in array
        public int max(int[] arr) {
            int max = Integer.MIN_VALUE;
            for (int x : arr) if (x > max) max = x;
            return max;
        }
    }
}
