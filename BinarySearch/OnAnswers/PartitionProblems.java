package OnAnswers;

/**
 * Unified Problem Statement:
 * --------------------------
 * Given an array of positive integers and an integer k, split the array into k contiguous subarrays
 * such that the maximum sum among these subarrays is minimized.
 *
 * Variants:
 * 1. Book Allocation: arr = pages in books, k = students
 * 2. Split Array Largest Sum (LeetCode 410): arr = numbers, k = subarrays
 * 3. Painter’s Partition: arr = board lengths, k = painters
 *
 * Common Idea:
 * - The answer lies between max(arr) (lower bound) and sum(arr) (upper bound).
 * - Use Binary Search to find the minimum feasible maximum sum.
 * - Use a greedy check to count how many subarrays are needed if the limit is mid.
 *
 * Time Complexity: O(n log(sum(arr)))
 * Space Complexity: O(1)
 */
public class PartitionProblems {

    // ---------------------- COMMON SOLUTION ----------------------

    /**
     * Generic method to solve all three problems
     *
     * @param arr array of positive integers
     * @param k   number of partitions (students / painters / subarrays)
     * @return minimized maximum sum of any partition
     */
    public static int minimizeLargestPartition(int[] arr, int k) {
        int n = arr.length;

        if (n < k) return -1; // Not enough elements for k partitions

        int low = 0, high = 0, ans = -1;

        // low = max element, high = sum of all elements
        for (int x : arr) {
            low = Math.max(low, x);
            high += x;
        }

        // Binary Search on Answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int partitions = countPartitions(arr, mid);
            if (partitions > k) {
                // Too many partitions → increase limit
                low = mid + 1;
            } else {
                // Valid partitioning, try minimizing further
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    /**
     * Helper function: Count how many partitions are required
     * if max sum per partition = limit
     */
    private static int countPartitions(int[] arr, int limit) {
        int partitions = 1;
        int currentSum = 0;

        for (int x : arr) {
            if (currentSum + x <= limit) {
                currentSum += x;
            } else {
                partitions++;
                currentSum = x;
            }
        }
        return partitions;
    }

    // ---------------------- PROBLEM-SPECIFIC METHODS ----------------------

    /**
     * Book Allocation Problem
     */
    public static int allocateBooks(int[] pages, int students) {
        return minimizeLargestPartition(pages, students);
    }

    /**
     * Split Array Largest Sum (LeetCode 410)
     */
    public static int splitArrayLargestSum(int[] nums, int k) {
        return minimizeLargestPartition(nums, k);
    }

    /**
     * Painter’s Partition Problem
     */
    public static int paintersPartition(int[] boards, int painters) {
        return minimizeLargestPartition(boards, painters);
    }

    // ---------------------- MAIN FOR TESTING ----------------------

    public static void main(String[] args) {
        // Book Allocation
        int[] books = {12, 34, 67, 90};
        int students = 2;
        System.out.println("Book Allocation: " + allocateBooks(books, students)); // Expected: 113

        // Split Array Largest Sum
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println("Split Array Largest Sum: " + splitArrayLargestSum(nums, k)); // Expected: 18

        // Painter’s Partition
        int[] boards = {10, 20, 30, 40};
        int painters = 2;
        System.out.println("Painter's Partition: " + paintersPartition(boards, painters)); // Expected: 60
    }
}
