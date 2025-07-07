#include <stdio.h>

// Function to swap two elements
void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Partition function that selects the last element as pivot
int partition(int arr[], int low, int high) {
    int pivot = arr[high]; // Choosing the last element as pivot
    int i = low - 1; // Index of smaller element

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) { // If current element is smaller than the pivot
            i++; // Increment index of smaller element
            swap(&arr[i], &arr[j]); // Swap the elements
        }
    }
    swap(&arr[i + 1], &arr[high]); // Swap the pivot element to its correct position
    return i + 1; // Return the partition index
}

// Quick Sort function
void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high); // Get the partition index

        // Display the array after each partitioning
        printf("Array after partitioning with pivot %d: ", arr[pi]);
        for (int k = 0; k <= high; k++) {
            printf("%d ", arr[k]);
        }
        printf("\n");

        // Recursively sort the elements before and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int main() {
    int arr[] = {40, 20, 10, 80, 60, 50, 7, 30, 100}; // Given array
    int n = sizeof(arr) / sizeof(arr[0]); // Calculate the number of elements

    printf("Original array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    quickSort(arr, 0, n - 1); // Perform quick sort

    printf("Sorted array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
