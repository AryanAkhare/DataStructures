package Arrays;

import java.util.HashSet;

public class LongestConsec {

    // ✅ Problem Statement:
    /*
        Q: Find the length of the longest consecutive elements sequence in an unsorted array.
        - You must solve it in O(n) time for the optimal version.
        - A consecutive sequence means numbers like [1, 2, 3, 4] (each +1 of previous)

        Examples:
        Input:  [1, 2, 3, 4, 5, 8, 9, 10]
        Output: 5  -> [1, 2, 3, 4, 5]

        Input:  [100, 4, 200, 1, 3, 2]
        Output: 4  -> [1, 2, 3, 4]
    */

    // 🔁 Brute Force Approach - O(n^2)
    /*
        For every element arr[i], check if arr[i]+1, arr[i]+2,... exist using linear search.
        Count how long the sequence goes.
        Time complexity is bad due to repeated scanning.
    */
    public static int bruteLongestConsec(int arr[]) {
        int longest = 1;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int count = 1;

            // Keep checking if x+1 exists in the array
            while (linearSearch(arr, x + 1) == true) {
                x++;
                count++;
            }

            longest = Math.max(longest, count);
        }
        return longest;
    }

    // ⚡ Optimal Approach - O(n)
    /*
        1. Add all elements to a HashSet for O(1) lookups.
        2. For each number, only start counting if it's the beginning of a sequence (i.e., i-1 not in set).
        3. Count how far the sequence continues (i+1, i+2, ...).
        4. Track the maximum length found.
    */
    public static int OptimalLongestConsec(int arr[]) {
        int longest = 1;
        HashSet<Integer> hs = new HashSet<>();

        // Add all elements to the set
        for (int i : arr) {
            hs.add(i);
        }

        for (int i : arr) {
            // Start only if i-1 doesn't exist (i is start of sequence)
            if (!hs.contains(i - 1)) {
                int x = i;
                int count = 1;

                // Count consecutive elements: i+1, i+2, ...
                while (hs.contains(x + 1)) {
                    x++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    // 🔍 Helper function: Linear search for brute force
    public static boolean linearSearch(int arr[], int target) {
        for (int x : arr) {
            if (x == target) {
                return true;
            }
        }
        return false;
    }

    // 🚀 Driver Code
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 8, 9, 10};

        // System.out.println(bruteLongestConsec(arr)); // Uncomment to test brute force
        System.out.println(OptimalLongestConsec(arr)); // Output: 5
    }
}
