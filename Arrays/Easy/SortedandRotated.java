package Arrays.Easy;

// LEETCODE-1752
// Problem: Check if an array is sorted (non-decreasing) and rotated at most once.
// A rotation means shifting elements circularly, e.g. [3,4,5,1,2] is a rotated version of [1,2,3,4,5].

public class SortedandRotated {

    private static boolean check(int a[]) {
        int count = 0;      // count how many "drops" we see in the array
        int n = a.length;

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Compare each element with the next one, 
            // use modulo to wrap around and make it circular
            if (a[i] > a[(i + 1) % n]) {
                count++;    // Found one place where order breaks
            }

            // If more than one break is found, it's not sorted-rotated
            if (count > 1) {
                return false;
            }
        }

        // If we see at most one break, it's sorted and rotated
        return true;
    }

    public static void main(String[] args) {
        int a[] = {3, 4, 5, 1, 2}; // sorted array [1,2,3,4,5] rotated
        int b[] = {2, 1, 3, 4};    // not valid rotation of sorted array

        System.out.println(check(a)); // true
        System.out.println(check(b)); // false
    }
}
