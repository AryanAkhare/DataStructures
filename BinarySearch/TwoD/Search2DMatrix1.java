class Search2DMatrix1 {

    /**
     * Problem Statement (LeetCode 74 - Search a 2D Matrix):
     * -----------------------------------------------------
     * You are given an m x n matrix 'arr' where:
     *   1. Each row is sorted in ascending order.
     *   2. The first integer of each row is greater than the last integer of the previous row.
     *
     * Task: Return true if the target is found in the matrix, otherwise return false.
     */

    // ----------------------------------------------------
    // 1. Brute Force Approach
    // ----------------------------------------------------
    public boolean BrutesearchMatrix(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;

        // Intuition:
        // Check every element one by one.
        // Very simple, but inefficient.

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
    // Time Complexity: O(n*m)  → because we may scan all elements
    // Space Complexity: O(1)   → no extra space


    // ----------------------------------------------------
    // 2. Better Approach (Row Identification + Binary Search)
    // ----------------------------------------------------
    public boolean bettersearchMatrix(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;

        // Intuition:
        // Instead of searching all elements,
        // use the property that each row is sorted.
        // Step 1: Find the row where target can lie
        //   -> target must be between first and last element of that row
        // Step 2: Apply Binary Search only in that row.

        for (int i = 0; i < n; i++) {
            if (arr[i][0] <= target && target <= arr[i][m - 1]) {
                return BS(arr[i], target);  // search only in this row
            }
        }
        return false;
    }
    // Time Complexity: O(n + log m)
    //   -> O(n) for scanning rows
    //   -> O(log m) for binary search in the right row
    // Space Complexity: O(1)


    // ----------------------------------------------------
    // 3. Optimal Approach (Flatten Matrix + Binary Search)
    // ----------------------------------------------------
    public boolean searchMatrix(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;
        int low = 0;
        int high = n * m - 1;  // treating the whole matrix as a flat sorted array

        // Intuition:
        // The matrix is sorted row-wise and next row starts after previous row ends.
        // So if we "flatten" the matrix into a 1D array, it is globally sorted.
        //
        // Example:
        // arr = [
        //   [1, 3, 5, 7],
        //   [10, 11, 16, 20],
        //   [23, 30, 34, 50]
        // ]
        // Flattened = [1, 3, 5, 7, 10, 11, 16, 20, 23, 30, 34, 50]
        //
        // Now index mapping:
        // mid → row = mid / m , col = mid % m
        // Say m=4 and mid=7 → row=7/4=1 , col=7%4=3 → arr[1][3]=20

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / m;   // integer division → gives row index
            int col = mid % m;   // remainder → gives column index

            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
    // Time Complexity: O(log(n*m)) → pure binary search on entire matrix
    // Space Complexity: O(1)


    // ----------------------------------------------------
    // Standard Binary Search helper
    // ----------------------------------------------------
    public boolean BS(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return true;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
