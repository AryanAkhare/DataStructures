package TwoD;
public class RowWithMaxOnes {

    /*
     * ===============================
     * 1️⃣ Brute-force Approach
     * ===============================
     * Problem Statement:
     * - Given a binary matrix `mat` of size m x n (only 0s and 1s).
     * - Find the row that contains the maximum number of 1s.
     * - If multiple rows have the same count, return the row with the smallest index.
     * - Return [rowIndex, numberOfOnesInThatRow].
     *
     * Example:
     * mat = [
     *   [0,1,1],
     *   [1,1,0],
     *   [1,1,1]
     * ]
     * Output: [2, 3]
     *
     * Intuition:
     * 1. Loop through each row.
     * 2. Count the number of 1s in the current row.
     * 3. Keep track of the maximum count found so far and its row index.
     * 4. If a new row has more ones, update max count and row index.
     *
     * Time Complexity: O(n*m) → check all rows and columns
     * Space Complexity: O(1)
     */
    public static int[] rowWithMaxOnesBrute(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int index = -1;   // row index with max ones
        int max = -1;     // max number of ones

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            if(count > max){
                max = count;
                index = i;
            }
        }
        return new int[]{index, max};
    }

    /*
     * ===============================
     * 2️⃣ Optimized Approach (Binary Search)
     * ===============================
     * Problem Statement:
     * - Given a binary matrix with **sorted rows** (0s first, then 1s).
     * - Find the row with the maximum number of 1s.
     * - Return the row index only.
     *
     * Example:
     * arr = [
     *   [0,0,1,1],
     *   [0,1,1,1],
     *   [0,0,0,1]
     * ]
     * Output: 1
     *
     * Intuition:
     * 1. Each row is sorted → we can use binary search to find first 1.
     * 2. Count of 1s = total columns - index of first 1.
     * 3. Track row with maximum 1s.
     *
     * Time Complexity: O(n * log m) → binary search on each row
     * Space Complexity: O(1)
     */
    class Solution {
        public int rowWithMax1s(int arr[][]) {
            int n = arr.length;
            int m = arr[0].length;

            int index = -1; // row index with max ones
            int max = 0;    // max number of ones

            for(int i = 0; i < n; i++){
                int count = m - lowerBound(arr[i], 1); // number of ones
                if(count > max){
                    max = count;
                    index = i;
                }
            }
            return index;
        }

        // Binary search: find first index where element >= x
        public int lowerBound(int[] arr, int x) {
            int ans = arr.length; // default if x is greater than all elements
            int low = 0, high = arr.length - 1;

            while(low <= high){
                int mid = low + (high - low)/2;
                if(arr[mid] >= x){
                    ans = mid;
                    high = mid - 1; // move left to find first occurrence
                } else {
                    low = mid + 1;  // move right
                }
            }
            return ans; // index of first 1
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[][] mat = {
            {0,1,1},
            {1,1,0},
            {1,1,1}
        };

        int[] bruteResult = rowWithMaxOnesBrute(mat);
        System.out.println("Brute-force → Row: " + bruteResult[0] + ", Ones: " + bruteResult[1]);
    }
}
