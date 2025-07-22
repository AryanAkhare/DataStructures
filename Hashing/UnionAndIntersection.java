package Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UnionAndIntersection {

    /*
     * Problem: Find the union and intersection of two arrays.
     * 
     * Union: All unique elements present in either array.
     * Intersection: Elements common to both arrays (only once if repeated).
     * 
     * Intuition:
     * - Use a HashSet to store unique elements for union.
     * - For intersection, use a HashSet to track elements of the first array,
     *   then check which elements from the second array exist in that set.
     */

    // Returns an array containing the union of two input arrays
    public static int[] unionOfArray(int num1[], int num2[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < num1.length; i++) {
            hs.add(num1[i]); // Add all elements of arr1
        }
        for (int i = 0; i < num2.length; i++) {
            hs.add(num2[i]); // Add all elements of arr2 (HashSet avoids duplicates)
        }

        // Convert HashSet to array
        int[] result = new int[hs.size()];
        int i = 0;
        for (int val : hs) {
            result[i++] = val;
        }
        return result;
    }

    // Returns an array containing the intersection of two input arrays
    public static int[] intersectionOfArray(int num1[], int num2[]) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> lt = new ArrayList<>();
        for (int x : num1) {
            set.add(x); // Add all elements of arr1
        }
        for (int x : num2) {
            if (set.contains(x)) {
                lt.add(x);       // Found common element
                set.remove(x);   // Ensure uniqueness in result
            }
        }

        // Convert list to array
        int result[] = new int[lt.size()];
        for (int i = 0; i < lt.size(); i++) {
            result[i] = lt.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        int[] union = unionOfArray(arr1, arr2);
        int inter[] = intersectionOfArray(arr1, arr2);

        System.out.println("Arr1:");
        for (int x : arr1) {
            System.out.print(x + " ");
        }

        System.out.println("\nArr2:");
        for (int x : arr2) {
            System.out.print(x + " ");
        }

        System.out.println("\nUNION:");
        for (int x : union) {
            System.out.print(x + " ");
        }

        System.out.println("\nINTERSECTION:");
        for (int x : inter) {
            System.out.print(x + " ");
        }
    }
}
