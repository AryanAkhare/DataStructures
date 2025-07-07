#include <stdio.h>

// Function to perform recursive binary search
int recursiveBinarySearch(int arr[], int left, int right, int target) {
    // Base case: if the left index exceeds the right index
    if (left > right) {
        return -1;  // Target not found
    }

    int mid = left + (right - left) / 2;  // Calculate mid index

    // Check if the target is present at mid
    if (arr[mid] == target) {
        return mid;  // Target found
    }

    // If target is smaller than mid, search in the left half
    if (target < arr[mid]) {
        return recursiveBinarySearch(arr, left, mid - 1, target);
    }

    // If target is larger than mid, search in the right half
    return recursiveBinarySearch(arr, mid + 1, right, target);
}

// Function to input a sorted array from the user
void inputSortedArray(int arr[], int size) {
    printf("Enter %d sorted integers:\n", size);
    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }
}

// Main function
int main() {
    int size, target;

    printf("Enter the number of elements in the sorted array: ");
    scanf("%d", &size);

    int arr[size];  // Declare array with user-defined size

    // Input sorted array
    inputSortedArray(arr, size);

    printf("Enter the integer to search for: ");
    scanf("%d", &target);

    // Perform binary search
    int result = recursiveBinarySearch(arr, 0, size - 1, target);

    // Display the result
    if (result != -1) {
        printf("Element %d found at index %d.\n", target, result);
    } else {
        printf("Element %d not found in the array.\n", target);
    }

    return 0;
}
