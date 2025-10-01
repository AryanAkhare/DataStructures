
/*
Problem: Minimum Number of Days to Make m Bouquets

Given an integer array `arr` where arr[i] represents the day the i-th flower will bloom, 
and two integers `m` (number of bouquets) and `k` (number of consecutive flowers per bouquet), 
find the **minimum number of days** needed to make `m` bouquets.

- Each bouquet requires exactly `k` consecutive flowers. 
- You cannot use the same flower in more than one bouquet.
- If it is impossible to make `m` bouquets, return -1.

Example:
Input: arr = [1, 10, 3, 10, 2], m = 3, k = 1
Output: 3
Explanation:
- Day 1: flowers blooming = [1], bouquets = 1
- Day 2: flowers blooming = [1, _, _, _, 2], bouquets = 2
- Day 3: flowers blooming = [1, _, 3, _, 2], bouquets = 3 → minimum day = 3

---

Brute Force Approach:
1. Start from day 1, simulate day by day.
2. On each day, check how many bouquets can be made.
3. Stop when number of bouquets >= m.
- Time Complexity: O(max(arr) * n)
- Space Complexity: O(1)
- Limitation: Too slow for large arrays with large bloom days.

Better Approach (Greedy Simulation):
1. Iterate through array once per candidate day.
2. Count consecutive bloomed flowers to form bouquets.
- Time Complexity: O(n * candidate_days)
- Space Complexity: O(1)
- Still slow if candidate_days (max bloom day) is large.

Optimal Approach (Binary Search on Days):
1. Observe: If we can make m bouquets in `d` days, we can also make them in any day > d.
2. Use binary search on the range [min(arr), max(arr)] to find the smallest day `d`.
3. For each mid day, use helper function `possible()` to check if `m` bouquets can be made.
- Time Complexity: O(n * log(max(arr)))
- Space Complexity: O(1)
- Efficient and scalable for large inputs.

Intuition:
- Treat days as a **monotonic function**: "can we make m bouquets in x days?"
- Binary search efficiently narrows down the minimum day.

References:
- LeetCode 1482: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
*/
class minBloomDays{

    // Function to check if it's possible to make m bouquets in 'day' days
    public boolean possible(int[] arr, int day, int k, int m) {
        int count = 0;
        int num = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                count++;
            } else {
                num += (count / k); // no of bouquets
                count = 0;
            }
        }
        num += (count / k);
        return num >= m;
    }

    // Function to find the minimum element in the array
    private int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
        }
        return min;
    }

    // Function to find the maximum element in the array
    private int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    public int minDaysBloom(int[] arr, int k, int m) {
        

        int low = findMin(arr);  // smallest bloom day
        int high = findMax(arr); // largest bloom day
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(arr, mid, k, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

/*
 Helper functions written separately:
 
 // Function to find the minimum element in the array
 private int findMin(int[] arr) {
     int min = Integer.MAX_VALUE;
     for (int num : arr) {
         min = Math.min(min, num);
     }
     return min;
 }

 // Function to find the maximum element in the array
 private int findMax(int[] arr) {
     int max = Integer.MIN_VALUE;
     for (int num : arr) {
         max = Math.max(max, num);
     }
     return max;
 }
*/
