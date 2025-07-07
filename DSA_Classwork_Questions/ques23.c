#include <stdio.h>

#define SIZE 14  // Size of the array

// Function to perform insertion sort
void insertionSort(char arr[], int size) {
    for (int i = 1; i < size; i++) {
        char key = arr[i];  // Current element to be inserted
        int j = i - 1;

        // Move elements that are greater than key to one position ahead
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];  // Shift element to the right
            j--;
        }
        arr[j + 1] = key;  // Insert the key at its correct position
    }
}

// Function to print the array
void printArray(char arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%c ", arr[i]);
    }
    printf("\n");
}

int main() {
    // Given array of characters
    char arr[SIZE] = {'S', 'T', 'R', 'U', 'C', 'T', 'U', 'R', 'E', 'S', 'D', 'A', 'T', 'A'};

    printf("Original array: \n");
    printArray(arr, SIZE);

    // Sort the array
    insertionSort(arr, SIZE);

    printf("Sorted array in ascending order: \n");
    printArray(arr, SIZE);

    return 0;
}
