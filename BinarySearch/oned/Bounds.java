package OneD;

import java.util.Arrays;

public class Bounds {

    /**
     * lowerBound: Finds the index of the first element >= target.
     * If no such element exists, returns arr.length.
     */
    public static int lowerBound(int[] arr, int target) {
        int ans = arr.length;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;       // candidate for lower bound
                high = mid - 1; // move left to find smaller index
            } else {
                low = mid + 1;  // move right
            }
        }
        return ans;
    }

    /**
     * upperBound: Finds the index of the first element > target.
     * If no such element exists, returns arr.length.
     */
    public static int upperBound(int[] arr, int target) {
        int ans = arr.length;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) { // strictly greater
                ans = mid;       // candidate for upper bound
                high = mid - 1; // move left to find smaller index
            } else {
                low = mid + 1;  // move right
            }
        }
        return ans;
    }

    /**
     * Binary Search approach to find Floor and Ceil
     * Floor: largest element <= x
     * Ceil: smallest element >= x
     * Array must be sorted for binary search to work.
     * Time Complexity: O(log n) after sorting (O(n log n) if sorting is needed).
     */
    public static int[] getFloorAndCeilBinary(int x, int[] arr) {
        Arrays.sort(arr); // Ensure sorted array
        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                // Exact match found — both floor and ceil are x
                floor = ceil = arr[mid];
                break;
            } else if (arr[mid] < x) {
                // Possible floor candidate
                floor = arr[mid];
                low = mid + 1; // move right to find a larger floor
            } else {
                // Possible ceil candidate
                ceil = arr[mid];
                high = mid - 1; // move left to find a smaller ceil
            }
        }
        return new int[]{floor, ceil};
    }

    /**
     * Linear Search approach to find Floor and Ceil
     * Works for unsorted array without sorting.
     * Time Complexity: O(n)
     */
    public static int[] getFloorAndCeilLinear(int x, int[] arr) {
        int floor = -1, ceil = -1;

        for (int num : arr) {
            if (num <= x) {
                if (floor == -1 || num > floor) {
                    floor = num; // largest <= x
                }
            }
            if (num >= x) {
                if (ceil == -1 || num < ceil) {
                    ceil = num; // smallest >= x
                }
            }
        }
        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 6, 8, 9, 6, 5, 5, 6};
        int[] arr2 = {5, 6, 8, 8, 6, 5, 5, 6};

        // Binary Search version (requires sorting)
        int[] res1 = getFloorAndCeilBinary(7, arr1);
        System.out.println("Binary Search (x=7): Floor = " + res1[0] + ", Ceil = " + res1[1]);

        int[] res2 = getFloorAndCeilBinary(10, arr2);
        System.out.println("Binary Search (x=10): Floor = " + res2[0] + ", Ceil = " + res2[1]);

        // Linear Search version (works without sorting)
        int[] res3 = getFloorAndCeilLinear(7, arr1);
        System.out.println("Linear Search (x=7): Floor = " + res3[0] + ", Ceil = " + res3[1]);

        int[] res4 = getFloorAndCeilLinear(10, arr2);
        System.out.println("Linear Search (x=10): Floor = " + res4[0] + ", Ceil = " + res4[1]);
    }
}
