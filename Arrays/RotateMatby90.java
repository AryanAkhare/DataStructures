package Arrays;

public class RotateMatby90 {

    // ✅ Rotate matrix 90 degrees CLOCKWISE
    public static void rotateby90(int[][] mat) {
        int n = mat.length;

        // Step 1: Transpose the matrix
        // Swap elements across the diagonal (i,j) ↔ (j,i)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse each row to complete clockwise rotation
        for (int i = 0; i < n; i++) {
            reverseArray(mat[i]);
        }
    }

    // ✅ Rotate matrix 90 degrees ANTI-CLOCKWISE
    public static void antiRotateby90(int[][] mat) {
        int n = mat.length;

        // Step 1: Transpose the matrix (same as above)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse each column to complete anti-clockwise rotation
        for (int col = 0; col < n; col++) {
            reverseCol(mat, col);
        }
    }

    // 🔄 Helper: Reverse a 1D array (used for reversing rows)
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // 🔄 Helper: Reverse a single column (used for anti-clockwise rotation)
    public static void reverseCol(int[][] mat, int col) {
        int top = 0;
        int bottom = mat.length - 1;
        while (top < bottom) {
            int temp = mat[top][col];
            mat[top][col] = mat[bottom][col];
            mat[bottom][col] = temp;
            top++;
            bottom--;
        }
    }

    // 🖨️ Print the matrix
    public static void print2Darray(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 🧪 Test both rotations
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        // Test Clockwise Rotation
        rotateby90(mat);
        System.out.println("90° Clockwise Rotation:");
        print2Darray(mat);

        System.out.println("***********************************");

        // New matrix for anti-clockwise test
        int[][] mat2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        // Test Anti-Clockwise Rotation
        antiRotateby90(mat2);
        System.out.println("90° Anti-Clockwise Rotation:");
        print2Darray(mat2);
    }
}
