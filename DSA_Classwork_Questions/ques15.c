#include <stdio.h>

void shellSort(int arr[], int n) {
    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            int j;

            // Shift earlier gap-sorted elements up until the correct location for temp is found
            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                arr[j] = arr[j - gap];
            }
            arr[j] = temp;
        }
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

    shellSort(arr, n);
    printf("Sorted array using Shell Sort: ");
    printArray(arr, n);

    return 0;
}
