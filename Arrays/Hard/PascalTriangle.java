package Arrays;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    /**
     * Generates the nth row (0-indexed) of Pascal's Triangle.
     * 
     * Intuition:
     * - The first element is always 1.
     * - Each next element can be computed from the previous one:
     *   C(n, k) = C(n, k-1) * (n - k + 1) / k
     * - Using this formula avoids recomputing factorials and 
     *   makes it O(r) instead of O(r^2).
     * 
     * Time Complexity: O(r)  (r = rowIndex)
     * Space Complexity: O(r)  (to store the row)
     */
    public static ArrayList<Integer> printNthRow(int rowIndex) {
        long val = 1; // Use long to avoid overflow during multiplication
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) { // <= to include the last element
            result.add((int) val); // Store value in result
            val = val * (rowIndex - i) / (i + 1); // Update for next column
        }

        return result;
    }

    /**
     * Generates the first n rows of Pascal's Triangle.
     * 
     * Intuition:
     * - For each row index i (from 0 to n-1), compute the ith row using printNthRow().
     * - Add each row (a list of integers) to our main list (list of lists).
     * 
     * Time Complexity: O(n^2) overall because we compute each row in O(r) 
     *   and sum over all rows → 1 + 2 + ... + n = O(n^2)
     * Space Complexity: O(n^2) to store all rows.
     */
    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            triangle.add(printNthRow(i));
        }

        return triangle;
    }

    public static void main(String[] args) {
        // Example usage:

        // Print 5th row (0-indexed, so rowIndex = 4)
        System.out.println("5th Row of Pascal's Triangle: " + printNthRow(4));
        // Output: [1, 4, 6, 4, 1]

        // Print first 5 rows
        List<List<Integer>> firstFiveRows = pascalTriangle(5);
        System.out.println("First 5 Rows of Pascal's Triangle:");
        for (List<Integer> row : firstFiveRows) {
            System.out.println(row);
        }
        /* Output:
           [1]
           [1, 1]
           [1, 2, 1]
           [1, 3, 3, 1]
           [1, 4, 6, 4, 1]
        */
    }
}
