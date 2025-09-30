package Arrays;

import java.util.ArrayList;

public class PlusOne {

    // ---------------------- INT[] VERSION ----------------------
    /**
     * Intuition:
     * We start from the last digit and add 1.
     * - If the digit is less than 9, we just add 1 and return.
     * - If the digit is 9, we make it 0 and carry over the 1 to the next left digit.
     * - If all digits are 9, we create a new array with an extra digit at the start (1 followed by zeros).
     *
     * Example:
     * Input: [1, 2, 3] → Output: [1, 2, 4]
     * Input: [9, 9, 9] → Output: [1, 0, 0, 0]
     *
     * Time Complexity: O(n) — we might visit every digit once.
     * Space Complexity: O(1) — except for the all-9 case where we create a new array of size n+1.
     */
    public static int[] plusOne(int digits[]) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {       // If no carry needed
                digits[i] += 1;
                return digits;         // Done
            }
            digits[i] = 0;             // Set to 0 and carry 1 to next iteration
        }

        // If we are here, all digits were 9
        int newArr[] = new int[n + 1];
        newArr[0] = 1; // rest are automatically 0
        return newArr;
    }

    // ---------------------- ARRAYLIST VERSION ----------------------
    /**
     * Intuition:
     * Same logic as the array version, but using ArrayList methods:
     * - Use get(i) to access elements.
     * - Use set(i, value) to update elements.
     * - Start from last digit, handle carry.
     * - If all digits are 9, add a new 1 at the start.
     *
     * Example:
     * Input: [1, 2, 3] → Output: [1, 2, 4]
     * Input: [9, 9, 9] → Output: [1, 0, 0, 0]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) extra space (modifies in place).
     */
    public static ArrayList<Integer> plusOneArrayList(ArrayList<Integer> digits) {
        int n = digits.size();

        for (int i = n - 1; i >= 0; i--) {
            int val = digits.get(i) + 1;
            if (val <= 9) {             // If no carry needed
                digits.set(i, val);
                return digits;          // Done
            }
            digits.set(i, 0);           // Set to 0 and carry
        }

        // If we are here, all digits were 9 → insert 1 at front
        digits.add(0, 1);
        return digits;
    }

    public static void main(String[] args) {
        // Example usage for int[]
        int a[] = {9, 9, 9};
        int result1[] = plusOne(a);
        for (int num : result1) {
            System.out.print(num + " "); // Output: 1 0 0 0
        }
        System.out.println();

        // Example usage for ArrayList<Integer>
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(9);
        ArrayList<Integer> result2 = plusOneArrayList(list);
        for (int num : result2) {
            System.out.print(num + " "); // Output: 1 3 0
        }
    }
}
