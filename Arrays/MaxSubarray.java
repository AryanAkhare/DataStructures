package Arrays;

public class MaxSubarray {

    // Function to find the maximum sum of a contiguous subarray
    public static int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE; // To store maximum sum found so far
        int sum = 0;                  // Running sum of current subarray

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];          // Add current element to sum

            // Update maxi if current sum is greater
            if (sum > maxi) {
                maxi = sum;
            }

            // If sum goes negative, reset it (negative sum won't help future subarrays)
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxi;
    }

    // Function to print the subarray giving the maximum sum
    public static void printMaxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE; // To store the maximum sum
        int sum = 0;                  // Running subarray sum
        int start = 0;                // Marks where a new subarray starts
        int startx = -1;              // Final start index of max subarray
        int endx = -1;                // Final end index of max subarray

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) start = i; // Potential new subarray starting point

            sum += nums[i];          // Add current element to sum

            // Update maxi and subarray indices if needed
            if (sum > maxi) {
                maxi = sum;
                startx = start;
                endx = i;
            }

            // Reset sum if it's negative
            if (sum < 0) {
                sum = 0;
            }
        }

        // Print the subarray from startx to endx
        System.out.print("Max subarray is: [");
        for (int i = startx; i <= endx; i++) {
            System.out.print(nums[i]);
            if (i != endx) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Start index: " + startx + ", End index: " + endx);
    }

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max sum: " + maxSubArray(arr)); // Output: 6
        printMaxSubArray(arr);                              // Output: [4, -1, 2, 1]
    }
}
