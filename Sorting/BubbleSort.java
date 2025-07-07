import java.util.*;

class BubbleSort {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    // Bubble Sort Algorithm:
    // Repeatedly compare adjacent elements.
    // Swap them if they are in the wrong order.
    // After each pass, the largest unsorted element moves to its correct position.
    // Repeat until the array is sorted.

    public static void main(String[] args) {
        int arr[] = {1, 23, 7, 8, 3, 2};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        printArray(arr);
    }
}
