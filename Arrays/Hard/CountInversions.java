package Arrays.Hard;

/**
 * TUF-Style Revision File: Count Inversions
 *
 * Problem:
 * Count the number of inversions in an array.
 * An inversion is a pair (i, j) such that i < j and arr[i] > arr[j].
 *
 * Approach:
 * 1. Brute Force -> O(n^2)
 * 2. Optimal Merge Sort -> O(n log n)
 */

public class CountInversions {

    // ------------------------------
    // 1. Brute Force Approach
    // ------------------------------
    static int inversionCountBrute(int arr[]) {
        int count = 0;
        // Compare every pair (i, j) where i < j
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // ------------------------------
    // 2. Optimal Merge Sort Approach
    // ------------------------------

    // Main function to count inversions using merge sort
    static int inversionCountOptimal(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    // Recursive merge sort that also counts inversions
    private static int mergeSortAndCount(int[] arr, int low, int high) {
        int invCount = 0;

        if (low < high) {
            int mid = low + (high - low) / 2;

            // Count inversions in left half
            invCount += mergeSortAndCount(arr, low, mid);

            // Count inversions in right half
            invCount += mergeSortAndCount(arr, mid + 1, high);

            // Count split inversions while merging
            invCount += mergeAndCount(arr, low, mid, high);
        }

        return invCount;
    }

    // Merge two sorted halves and count inversions across halves
    private static int mergeAndCount(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // Create subarrays for left and right halves
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) left[i] = arr[low + i];
        for (int i = 0; i < n2; i++) right[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = low, invCount = 0;

        // Merge subarrays and count inversions
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                invCount += (n1 - i); // all remaining elements in left are inversions
            }
        }

        // Copy remaining elements
        while (i < n1) arr[k++] = left[i++];
        while (j < n2) arr[k++] = right[j++];

        return invCount;
    }

    // ------------------------------
    // Driver
    // ------------------------------
    public static void main(String[] args) {

        int[] arr1 = {5, 3, 2, 1};
        System.out.println("Brute Force Inversions: " + inversionCountBrute(arr1));

        int[] arr2 = {2, 4, 1, 3, 5};
        System.out.println("Optimal Merge Sort Inversions: " + inversionCountOptimal(arr2));
    }
}
