package Arrays;
import java.util.ArrayList;

public class PrintSpiral {

    /*
     * Function to traverse a matrix in spiral order.
     * Example input matrix:
     *   1  2  3
     *   4  5  6
     *   7  8  9
     *
     * Spiral order output:
     * [1, 2, 3, 6, 9, 8, 7, 4, 5]
     *
     * Intuition:
     * - We keep track of 4 boundaries: top, bottom, left, right.
     * - We move in 4 directions: 
     *   1. Left → Right (Top row)
     *   2. Top → Bottom (Rightmost column)
     *   3. Right → Left (Bottom row)
     *   4. Bottom → Top (Leftmost column)
     * - After each pass, we shrink the boundary inwards.
     * - Stop when top > bottom or left > right.
     */

    public static ArrayList<Integer> spirallyTraverse(int[][] mat) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int n = mat.length;        // number of rows
        int m = mat[0].length;     // number of columns
        
        // Defining the boundaries of the matrix
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        // Traverse until all layers are covered
        while (top <= bottom && left <= right) {

            // 1️⃣ Traverse from Left → Right on the Top row
            for (int i = left; i <= right; i++) {
                ans.add(mat[top][i]);
            }
            top++;  // Top row done, move boundary down

            // 2️⃣ Traverse from Top → Bottom on the Rightmost column
            for (int i = top; i <= bottom; i++) {
                ans.add(mat[i][right]);
            }
            right--;  // Rightmost column done, move boundary left

            // 3️⃣ Traverse from Right → Left on the Bottom row (if still valid)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(mat[bottom][i]);
                }
                bottom--;  // Bottom row done, move boundary up
            }

            // 4️⃣ Traverse from Bottom → Top on the Leftmost column (if still valid)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(mat[i][left]);
                }
                left++;  // Leftmost column done, move boundary right
            }
        }

        return ans;
    }

    // For testing
    public static void main(String[] args) {
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        ArrayList<Integer> result = spirallyTraverse(matrix);
        System.out.println(result);  // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}

