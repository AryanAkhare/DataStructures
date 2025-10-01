package OnAnswers;

/**
 * Problem Statement:
 * ------------------
 * You are given an array `arr[]` where each element represents the number of pages in a book,
 * and an integer `m` representing the number of students. The books must be allocated to students
 * in contiguous order (no shuffling). Each student gets at least one book.
 * The goal is to minimize the maximum number of pages assigned to any student.
 * If allocation is not possible (i.e., number of students > number of books), return -1.
 *
 * Example:
 * arr = {12, 34, 67, 90}, m = 2
 * Allocation:
 *   - Student 1: {12, 34, 67} → 113 pages
 *   - Student 2: {90}         → 90 pages
 * Minimum possible maximum pages = 113
 *
 * Approaches:
 * -----------
 * 1. Brute Force: Try all possible partitions → O(n^2 * m) approx.
 * 2. Optimized (Binary Search on Answer): Use binary search between [max(arr), sum(arr)]
 *    and check feasibility using a greedy allocation function → O(n log(sum(arr))).
 */
public class AllocateBooks {

    /**
     * Optimized method using Binary Search on Answer.
     *
     * @param arr array of pages in books
     * @param m   number of students
     * @return minimum maximum pages any student gets
     */
    public static int findPages(int arr[], int m) {
        int n = arr.length;
        int low = 0;
        int high = 0;
        int ans = -1;

        // If books are fewer than students, allocation is impossible
        if (n < m) {
            return ans;
        }

        // low = max(arr), because at least one student must get the largest book
        // high = sum(arr), because in worst case one student gets all books
        for (int x : arr) {
            low = Math.max(low, x);
            high += x;
        }

        // Binary search to minimize the maximum pages
        while (low <= high) {
            int mid = low + (high - low) / 2; // potential max pages
            int numOfStudents = calcSum(arr, mid);

            if (numOfStudents > m) {
                // Too many students needed, increase limit
                low = mid + 1;
            } else {
                // Possible allocation, try for smaller maximum
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }

    /**
     * Helper function to count how many students are needed
     * if each student can be assigned at most `limit` pages.
     *
     * @param arr   array of pages
     * @param limit max pages a student can take
     * @return number of students required
     */
    public static int calcSum(int[] arr, int limit) {
        int students = 1;
        int pages = 0;

        for (int x : arr) {
            if (pages + x <= limit) {
                // Assign book to current student
                pages += x;
            } else {
                // Allocate to next student
                students++;
                pages = x;
            }
        }
        return students;
    }

    /**
     * Brute Force method (Recursive) - Try all partitions.
     * O(n^2 * m) approx, not efficient for large inputs.
     *
     * @param arr array of pages
     * @param n   number of books
     * @param m   number of students
     * @return minimum maximum pages
     */
    public static int bruteForce(int[] arr, int n, int m) {
        // If only one student, he must take all books
        if (m == 1) {
            int sum = 0;
            for (int i = 0; i < n; i++) sum += arr[i];
            return sum;
        }

        // If only one book, return its pages
        if (n == 1) {
            return arr[0];
        }

        int result = Integer.MAX_VALUE;

        // Try placing the divider before every book from 1 to n
        for (int i = 1; i <= n; i++) {
            // Max of (bruteForce for first i books, sum of remaining books)
            int left = bruteForce(arr, i, m - 1);
            int right = 0;
            for (int j = i; j < n; j++) right += arr[j];
            result = Math.min(result, Math.max(left, right));
        }

        return result;
    }

    // --------------------------
    // Time Complexity:
    // --------------------------
    // Binary Search Method: O(n log(sum(arr)))
    // Brute Force Method: O(n^2 * m) approx (exponential recursion for large n)
    //
    // Space Complexity: O(1) for binary search, O(m) recursion depth for brute force
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int students = 2;

        System.out.println("Books: {12, 34, 67, 90}, Students = 2");
        System.out.println("Brute Force Answer: " + bruteForce(arr, arr.length, students));
        System.out.println("Optimized Answer:   " + findPages(arr, students));
    }
}
