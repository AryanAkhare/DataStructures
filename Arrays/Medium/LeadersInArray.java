package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

/**
 * Leaders in an array: An element is a leader if no element to its right is greater than it.
 *
 * Brute-force intuition (leaders): For each element, scan all elements to its right. If any is greater,
 * then current is not a leader. This is O(n^2).
 *
 * Optimal intuition (leadersOptimal): Traverse from right to left maintaining the maximum seen so far.
 * Any element >= max so far is a leader; update max. This is O(n). We collect in reverse order and then reverse at end.
 * Use Integer.MIN_VALUE to initialize the max so that any value in array is >= it.
 *
 * Example input: [0, 22, 12, 3, 0, 6]
 * Leaders (left-to-right): [22, 12, 6]
 */
public class LeadersInArray {

    /**
     * Brute-force leader finding: for each element check if any element to its right is greater.
     */
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean isLeader = true; // assume leader until disproven
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                result.add(arr[i]);
            }
        }
        return result;
    }

    /**
     * Optimal leader finding using reverse traversal and tracking max to the right.
     */
    static ArrayList<Integer> leadersOptimal(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE; // ensures first comparison always captures last element as leader
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                result.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(result); // reverse to restore left-to-right order
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {0, 22, 12, 3, 0, 6};
        System.out.println("Input: " + Arrays.toString(arr));

        ArrayList<Integer> brute = leaders(arr);
        System.out.println("Leaders (brute-force): " + brute);

        ArrayList<Integer> optimal = leadersOptimal(arr);
        System.out.println("Leaders (optimal): " + optimal);
    }
}
