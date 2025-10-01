package Arrays.Easy;

import java.util.*;

public class UnionofSortedArray {

    // Function to return union of two sorted arrays
    public static List<Integer> unionSorted(int arr1[], int arr2[]) {
        int i = 0, j = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;

        List<Integer> union = new ArrayList<>();

        // Traverse both arrays
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                addToUnion(union, arr1[i]);
                i++;
            } else if (arr2[j] < arr1[i]) {
                addToUnion(union, arr2[j]);
                j++;
            } else { // equal
                addToUnion(union, arr1[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements of arr1
        while (i < n1) {
            addToUnion(union, arr1[i]);
            i++;
        }

        // Add remaining elements of arr2
        while (j < n2) {
            addToUnion(union, arr2[j]);
            j++;
        }

        return union;
    }

    // Helper to avoid duplicates
    private static void addToUnion(List<Integer> union, int val) {
        if (union.isEmpty() || union.get(union.size() - 1) != val) {
            union.add(val);
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 2, 3, 5};
        int arr2[] = {2, 3, 4, 5, 6};

        List<Integer> result = unionSorted(arr1, arr2);
        System.out.println(result); // [1, 2, 3, 4, 5, 6]
    }
}
