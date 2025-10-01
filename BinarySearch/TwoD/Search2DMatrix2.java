package TwoD;
/**
 * Search2DMatrix2_Explained.java
 * -------------------------------
 * Problem Statement:
 * Given a 2D integer matrix `mat[][]` of size n x m, where every row and every column
 * is sorted in strictly increasing order (or non-decreasing), and a number `x`, determine
 * whether `x` exists in the matrix.
 *
 * Example inputs and outputs:
 *  - mat = [[3, 30, 38],[20, 52, 54],[35, 60, 69]], x = 62  -> false
 *  - mat = [[18, 21, 27],[38, 55, 67]], x = 55             -> true
 *  - mat = [[1,2,3],[4,5,6],[7,8,9]], x = 3                -> true
 *
 * Approaches included in this file:
 *  1) bruteForceSearch        - check every element (O(n*m))
 *  2) binarySearchRows       - binary-search each row where the target could lie (O(n*log m))
 *  3) staircaseSearch (best) - start at top-right and eliminate row/column each step (O(n + m))
 *
 * The file focuses on clear, commented intuition for the "better" (binarySearchRows)
 * and "optimal" (staircaseSearch) approaches with a small dry-run example for staircase.
 */

public class Search2DMatrix2 {

    // -----------------------------
    // 0) UTIL: handle empty edge-cases
    // -----------------------------
    private static boolean isEmpty(int[][] mat) {
        return mat == null || mat.length == 0 || mat[0].length == 0;
    }


    // --------------------------------------------------
    // 1) Brute-force approach
    //    - Intuition: check every element until you find x
    //    - Time: O(n * m) (scan entire matrix in worst-case)
    //    - Space: O(1)
    // --------------------------------------------------
    public static boolean bruteForceSearch(int[][] mat, int x) {
        if (isEmpty(mat)) return false;

        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == x) return true;
            }
        }
        return false;
    }


    // --------------------------------------------------
    // 2) Better approach: binary-search each candidate row
    //    - Intuition (detailed):
    //      Each row is sorted in increasing order. So for a given row i,
    //      if x lies between row[i][0] and row[i][m-1], x may be in that row.
    //      Instead of scanning the row linearly, perform a binary search on that row.
    //      We still check rows one-by-one (to locate candidate rows), but the per-row
    //      cost is O(log m) rather than O(m).
    //    - When is it useful?
    //      Useful when m is large and n is moderate: reduces O(n*m) to O(n*log m).
    //      If many rows' ranges exclude x quickly, you'll only binary-search a few rows.
    //    - Time complexity: O(n * log m)
    //    - Space complexity: O(1)
    // --------------------------------------------------
    public static boolean binarySearchRows(int[][] mat, int x) {
        if (isEmpty(mat)) return false;

        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            // A quick range check to avoid searching rows that can't contain x
            if (mat[i][0] <= x && x <= mat[i][m - 1]) {
                if (binarySearch(mat[i], x)) return true;
            }
        }
        return false;
    }

    // Standard binary search on a sorted 1D array
    private static boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }


    // --------------------------------------------------
    // 3) Optimal approach (staircase / linear elimination)
    //    - Intuition (detailed):
    //      Start at the top-right corner of the matrix: position (row=0, col=m-1).
    //      At any position (r, c):
    //        * All elements to the left (same row, columns < c) are <= mat[r][c] (row sorted).
    //        * All elements below (same column, rows > r) are >= mat[r][c] (column sorted).
    //      Therefore:
    //        - If mat[r][c] == x  --> found.
    //        - If mat[r][c] > x   --> every element in column c from row r..n-1 is >= mat[r][c] > x,
    //                               so x cannot be in column c (for remaining rows). We can safely
    //                               eliminate column c by doing c-- (move left).
    //        - If mat[r][c] < x   --> every element in row r from column 0..c is <= mat[r][c] < x,
    //                               so x cannot be in row r (in the remaining columns). We can safely
    //                               eliminate row r by doing r++ (move down).
    //
    //      This eliminates at least one entire row or column per step; after at most (n + m)
    //      steps we either find x or exhaust the search space.
    //
    //    - Dry run example (matrix = [[18,21,27],[38,55,67]], x = 55):
    //        1) start at (0,2) -> mat[0][2] = 27. 27 < 55 -> row++ (eliminate row 0)
    //        2) now at (1,2) -> mat[1][2] = 67. 67 > 55 -> col-- (eliminate column 2)
    //        3) now at (1,1) -> mat[1][1] = 55 -> found!
    //
    //    - Time complexity: O(n + m)  (each step moves either left or down, at most n + m moves)
    //    - Space complexity: O(1)
    // --------------------------------------------------
    public static boolean staircaseSearch(int[][] mat, int x) {
        if (isEmpty(mat)) return false;

        int n = mat.length;
        int m = mat[0].length;

        // Start at top-right
        int row = 0, col = m - 1;

        while (row < n && col >= 0) {
            int val = mat[row][col];
            if (val == x) return true;
            else if (val > x) {
                // current is too large -> eliminate this column for the remaining rows
                col--;
            } else {
                // current is too small -> eliminate this row for the remaining columns
                row++;
            }
        }
        return false;
    }


   

}
