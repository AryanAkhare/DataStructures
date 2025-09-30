package Arrays;

public class SetZeroMatrix {

    /*
     * ✅ Brute Force Approach (NEGATIVE VALUES ALLOWED)
     * Uses extra space to track zeroed rows and columns
     * 
     * Time Complexity: O(n * m)
     * Space Complexity: O(n + m)
     */
    public static void BRUTESetZeroMatrixNEGALLOWED(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] ro = new boolean[rows]; // track which rows should be zeroed
        boolean[] co = new boolean[cols]; // track which cols should be zeroed

        // First pass: mark the rows and cols that need to be zeroed
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    ro[i] = true;
                    co[j] = true;
                }
            }
        }

        // Second pass: set elements to 0 if row or col is marked
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (ro[i] || co[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /*
     * ❌ Brute Force In-Place Approach (ONLY FOR POSITIVE VALUES)
     * Modifies matrix during traversal by marking with -1
     * Assumes no negative values in the matrix
     * 
     * Time Complexity: O(n * m * (n + m)) worst case
     * Space Complexity: O(1) (no extra space used)
     */
    public static void BRUTESetZeroMatrixPOS(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Mark all non-zero affected cells as -1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    // Mark entire row
                    for (int k = 0; k < cols; k++) {
                        if (matrix[i][k] != 0)
                            matrix[i][k] = -1;
                    }
                    // Mark entire column
                    for (int k = 0; k < rows; k++) {
                        if (matrix[k][j] != 0)
                            matrix[k][j] = -1;
                    }
                }
            }
        }

        // Step 2: Convert all -1 to 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }
    }

    /*
     * 🚀 Optimal Approach (O(1) space) — modifies matrix in-place
     * Uses first row and first column as markers to track zeroed rows/cols
     * 
     * Time Complexity: O(n * m)
     * Space Complexity: O(1)
     */
    public static void OptimalSetZeroMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1: Check if first row has a zero
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2: Check if first column has a zero
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Step 3: Use first row and col as marker for other cells
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark row
                    matrix[0][j] = 0; // mark col
                }
            }
        }

        // Step 4: Zero out cells based on markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Zero out first row if needed
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 6: Zero out first column if needed
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
