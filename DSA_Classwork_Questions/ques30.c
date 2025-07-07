#include <stdio.h>

// Function to perform Shell Sort
void shellSort(int arr[], int n) {
    // Start with a large gap, then reduce the gap
    for (int gap = n / 2; gap > 0; gap /= 2) {
        // Do a gapped insertion sort for this gap size
        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            int j;

            // Shift earlier gap-sorted elements up until the correct location for arr[i] is found
            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                arr[j] = arr[j - gap];
            }
            arr[j] = temp;

            // Print the array after each insertion
            printf("Array after inserting element %d: ", temp);
            for (int k = 0; k < n; k++) {
                printf("%d ", arr[k]);
            }
            printf("\n");
        }
    }
}

// Main function
int main() {
    int arr[] = {21, 99, 87, 74, 97, 102, 56, 78, 85, 94}; // Given array
    int n = sizeof(arr) / sizeof(arr[0]); // Calculate the number of elements

    printf("Original array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n\n");

    shellSort(arr, n); // Perform Shell Sort

    printf("Sorted array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
