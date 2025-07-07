#include <stdio.h>

void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;

        // Move elements that are greater than key to one position ahead of their current position
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int arr[] = {5678, 2341, 90, 3219, 7676, 8704, 4561, 5000};
    int n = sizeof(arr) / sizeof(arr[0]);

    insertionSort(arr, n);
    printf("Sorted array using Insertion Sort: ");
    printArray(arr, n);

    return 0;
}
