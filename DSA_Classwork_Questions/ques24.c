#include <stdio.h>

#define SIZE 10  // Number of integers to input

// Function to perform insertion sort in ascending order
void insertionSortAscending(int arr[], int size) {
    for (int i = 1; i < size; i++) {
        int key = arr[i];
        int j = i - 1;

        // Move elements greater than key to one position ahead
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

// Function to perform insertion sort in descending order
void insertionSortDescending(int arr[], int size) {
    for (int i = 1; i < size; i++) {
        int key = arr[i];
        int j = i - 1;

        // Move elements less than key to one position ahead
        while (j >= 0 && arr[j] < key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

// Function to print the array
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int arr[SIZE];
    int choice;

    // Input 10 integers
    printf("Enter 10 integers:\n");
    for (int i = 0; i < SIZE; i++) {
        scanf("%d", &arr[i]);
    }

    // Display menu
    printf("\nChoose sorting order:\n");
    printf("1. Ascending Order\n");
    printf("2. Descending Order\n");
    printf("Enter your choice (1 or 2): ");
    scanf("%d", &choice);

    // Sort based on user choice
    switch (choice) {
        case 1:
            insertionSortAscending(arr, SIZE);
            printf("Sorted array in ascending order:\n");
            break;
        case 2:
            insertionSortDescending(arr, SIZE);
            printf("Sorted array in descending order:\n");
            break;
        default:
            printf("Invalid choice! Please choose 1 or 2.\n");
            return 1;  // Exit the program with an error
    }

    // Print the sorted array
    printArray(arr, SIZE);
    return 0;
}
