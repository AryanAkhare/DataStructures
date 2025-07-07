#include <stdio.h>
#include <stdlib.h>

#define MAX 100 // Maximum size of the stack

// Global array to hold the stack elements
int stack[MAX]; 
int top = -1; // Initialize top to -1 (stack is empty)

// Function to check if the stack is empty
int isEmpty() {
    return (top == -1); // Returns 1 if empty, 0 otherwise
}

// Function to check if the stack is full
int isFull() {
    return (top == MAX - 1); // Returns 1 if full, 0 otherwise
}

// Function to push an element onto the stack
void push(int value) {
    if (isFull()) {
        printf("Stack Overflow! Cannot push %d\n", value);
        return; // Exit if stack is full
    }
    top++; // Increment top
    stack[top] = value; // Add value to stack
    printf("Pushed: %d\n", value);
}

// Function to pop two elements from the stack
void pop() {
    if (isEmpty()) {
        printf("Stack Underflow! Cannot pop elements\n");
        return; // Exit if stack is empty
    }

    // Check if there is only one element
    if (top == 0) {
        printf("Cannot remove the element. Only one element present.\n");
        return; // Exit if only one element
    }

    // Remove two elements
    int firstRemoved = stack[top]; // Pop first element
    top--; // Decrement top
    int secondRemoved = stack[top]; // Pop second element
    top--; // Decrement top again
    printf("Popped: %d and %d\n", firstRemoved, secondRemoved);
}

// Function to display the contents of the stack
void displayStack() {
    if (isEmpty()) {
        printf("Stack is empty!\n");
        return; // Exit if empty
    }
    printf("Stack elements: ");
    for (int i = 0; i <= top; i++) {
        printf("%d ", stack[i]); // Print elements in stack
    }
    printf("\n");
}

// Main function to demonstrate the modified stack operations
int main() {
    int choice, value;

    do {
        printf("\nMenu:\n");
        printf("1. Push\n");
        printf("2. Pop\n");
        printf("3. Display Stack\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice); // Take user input

        switch (choice) {
            case 1:
                printf("Enter value to push: ");
                scanf("%d", &value);
                push(value); // Push value onto stack
                break;
            case 2:
                pop(); // Pop values from stack
                break;
            case 3:
                displayStack(); // Display current stack contents
                break;
            case 4:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice! Please try again.\n");
        }
    } while (choice != 4); // Loop until exit choice is selected

    return 0; // Exit the program
}
