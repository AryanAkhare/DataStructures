// Suppose an array A contains 10 elements as follows: char A[100] = {“Nagpur”, “Nashik”,
// “Mumbai”, “Pune”, “Bhopal”, “Aurangabad”, “Delhi”, “Panji”, “Hydrabad”, “Chennai”};
// Write a program to sort the above array using Insertion Sort.
#include <stdio.h>
#include <string.h>

void insertionSort(char arr[][100], int n) {
    for (int i = 1; i < n; i++) {
        char key[100];
        strcpy(key, arr[i]); // Copy the current string into key
        int j = i - 1;

        // Move strings that are greater than key to one position ahead of their current position
        while (j >= 0 && strcmp(arr[j], key) > 0) {
            strcpy(arr[j + 1], arr[j]);
            j--;
        }
        strcpy(arr[j + 1], key);
    }
}

void printArray(char arr[][100], int n) {
    for (int i = 0; i < n; i++) {
        printf("%s\n", arr[i]);
    }
}

int main() {
    char A[10][100] = {
        "Nagpur", "Nashik", "Mumbai", "Pune", 
        "Bhopal", "Aurangabad", "Delhi", "Panji", 
        "Hyderabad", "Chennai"
    };
    int n = sizeof(A) / sizeof(A[0]);

    insertionSort(A, n);
    printf("Sorted array of city names:\n");
    printArray(A, n);

    return 0;
}
