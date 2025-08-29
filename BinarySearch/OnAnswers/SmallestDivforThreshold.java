package OnAnswers;

public class SmallestDivforThreshold {

    // ---------------- Brute Force Approach ----------------
    // Intuition:
    // - The divisor must lie between 1 and max element in the array.
    // - For each divisor d, compute sum = Σ ceil(arr[i] / d).
    // - If sum <= threshold, return d as the answer.
    // - This is very slow for large arrays and big max values.
    //
    // Time Complexity: O(n * max(arr))
    //   (n = array length, max(arr) = largest element in array)
    // Space Complexity: O(1)

    public static int BruteSmallestDivforThreshold(int arr[], int threshold) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        // Find maximum element
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // Try all possible divisors from 1 to max
        for (int d = 1; d <= max; d++) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                // ceil(arr[i] / d) = (arr[i] + d - 1) / d
                sum += (arr[i] + d - 1) / d;
            }
            if (sum <= threshold) {  // ✅ should check sum, not d
                return d;
            }
        }
        return -1;
    }

    // ---------------- Optimized Approach (Binary Search) ----------------
    // Intuition:
    // - Brute force is too slow because it checks all divisors up to max(arr).
    // - Observe: if a divisor d works (sum <= threshold), then any divisor > d
    //   will also work because larger divisor reduces the sum.
    // - This monotonic property allows Binary Search.
    //
    // Steps:
    // 1. Low = 1, High = max element
    // 2. While low <= high:
    //      - mid = (low + high) / 2
    //      - calculate sum with divisor = mid
    //      - if sum <= threshold → possible answer, move left (high = mid - 1)
    //      - else move right (low = mid + 1)
    // 3. Return the smallest valid divisor found.
    //
    // Time Complexity: O(n log(max(arr)))
    // Space Complexity: O(1)

    public int smallestDivisor(int[] nums, int threshold) {
        // Step 1: Find maximum element in nums
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int low = 1;
        int high = max;
        int ans = Integer.MAX_VALUE;

        // Step 2: Binary search on divisor
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = calcSum(nums, mid);

            if (sum <= threshold) {
                ans = mid;        // store current valid answer
                high = mid - 1;   // try smaller divisor
            } else {
                low = mid + 1;    // need bigger divisor
            }
        }

        return ans;
    }

    // Helper function to compute sum of ceil(nums[i] / divisor)
    private int calcSum(int[] nums, int divisor) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // Trick: ceil(a/b) = (a + b - 1) / b
            sum += (nums[i] + divisor - 1) / divisor;
        }
        return sum;
    }
}
