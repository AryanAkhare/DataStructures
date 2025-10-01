package TwoD;
// Peak Element Problems - TUF Style Solutions
// 
// -------------------------------------------------------
// We solve two problems here:
// 1. Find a peak element in 1D array
// 2. Find a peak element in 2D matrix
//
// A Peak element is an element that is strictly greater
// than its neighbors (or boundary conditions if at edge).
// -------------------------------------------------------



class Solution {

    // -------------------------
    // 1D ARRAY VERSION
    // -------------------------

    // Brute Force: O(n)
    // Check every element with its neighbors.
    public int findPeak1DBrute(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean leftOk = (i == 0) || (arr[i] > arr[i - 1]);   // left boundary handled
            boolean rightOk = (i == n - 1) || (arr[i] > arr[i + 1]); // right boundary handled

            if (leftOk && rightOk) {
                return i; // return index of peak
            }
        }
        return -1; // edge case
    }

    // Optimal: Binary Search O(log n)
    // Intuition:
    // - If arr[mid] < arr[mid+1], then peak must lie on the right.
    // - Else, peak is on the left or mid itself.
    public int findPeak1DOptimal(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // Peak lies in right half
                low = mid + 1;
            } else {
                // Peak lies in left half including mid
                high = mid;
            }
        }
        return low; // low == high -> peak index
    }


    // -------------------------
    // 2D MATRIX VERSION
    // -------------------------

    // Brute Force: O(n*m)
    // Simply scan all elements and check if it's peak.
    public int[] findPeak2DBrute(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = (i > 0) ? mat[i - 1][j] : -1;
                int down = (i < n - 1) ? mat[i + 1][j] : -1;
                int left = (j > 0) ? mat[i][j - 1] : -1;
                int right = (j < m - 1) ? mat[i][j + 1] : -1;

                if (mat[i][j] > up && mat[i][j] > down &&
                    mat[i][j] > left && mat[i][j] > right) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // no peak found
    }

    // Optimal: O(n log m)
    // Binary Search on columns.
    // 1. Pick middle column.
    // 2. Find max element in that column.
    // 3. Compare it with left & right neighbors.
    // 4. Move search space accordingly.
    public int[] findPeak2DOptimal(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // find row with maximum element in this column
            int row = maxElementInColumn(mat, mid);

            int left = (mid - 1 >= 0) ? mat[row][mid - 1] : -1;
            int right = (mid + 1 < m) ? mat[row][mid + 1] : -1;

            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[]{row, mid}; // peak found
            } else if (mat[row][mid] < left) {
                high = mid - 1; // move left
            } else {
                low = mid + 1; // move right
            }
        }

        return new int[]{-1, -1};
    }

    // Helper: find row index of max element in given column
    private int maxElementInColumn(int[][] mat, int col) {
        int maxVal = -1, index = -1;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                index = i;
            }
        }
        return index;
    }

    // -------------------------
    // DRIVER
    // -------------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        // 1D Example
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("1D Peak (Brute): " + sol.findPeak1DBrute(arr));
        System.out.println("1D Peak (Optimal): " + sol.findPeak1DOptimal(arr));

        // 2D Example
        int[][] mat = {
            {10, 8, 10, 10},
            {14, 13, 12, 11},
            {15, 9, 11, 21},
            {16, 17, 19, 20}
        };
        int[] peakBrute = sol.findPeak2DBrute(mat);
        System.out.println("2D Peak (Brute): (" + peakBrute[0] + ", " + peakBrute[1] + ")");
        int[] peakOpt = sol.findPeak2DOptimal(mat);
        System.out.println("2D Peak (Optimal): (" + peakOpt[0] + ", " + peakOpt[1] + ")");
    }
}
