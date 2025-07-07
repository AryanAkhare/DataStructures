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

// Function to pop an element from the stack
int pop() {
    if (isEmpty()) {
        printf("Stack Underflow! Cannot pop elements\n");
        return -1; // Return -1 to indicate error
    }
    return stack[top--]; // Return top element and decrement top
}

// Function to remove elements from odd positions
void removeOddPositions() {
    if (isEmpty()) {
        printf("Stack is empty! No elements to remove.\n");
        return;
    }

    // Temporary stack to hold elements
    int temp[MAX];
    int tempTop = -1; // Initialize temporary stack

    // Pop elements and keep only the even positioned ones
    for (int i = 0; i <= top; i++) {
        if ((i + 1) % 2 == 0) { // Check if the position is even
            temp[++tempTop] = stack[i]; // Push to temporary stack
        }
    }

    // Clear original stack
    top = -1;

    // Restore even positioned elements back to the original stack
    for (int i = 0; i <= tempTop; i++) {
        push(temp[i]); // Push back to the original stack
    }
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

// Main function to demonstrate stack operations
int main() {
    int choice, value;

    do {
        printf("\nMenu:\n");
        printf("1. Push\n");
        printf("2. Pop\n");
        printf("3. Remove Odd Positions\n");
        printf("4. Display Stack\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice); // Take user input

        switch (choice) {
            case 1:
                printf("Enter value to push: ");
                scanf("%d", &value);
                push(value); // Push value onto stack
                break;
            case 2:
                {
                    int poppedValue = pop(); // Pop value from stack
                    if (poppedValue != -1) {
                        printf("Popped: %d\n", poppedValue);
                    }
                }
                break;
            case 3:
                removeOddPositions(); // Remove odd positioned elements
                printf("Removed elements from odd positions.\n");
                break;
            case 4:
                displayStack(); // Display current stack contents
                break;
            case 5:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice! Please try again.\n");
        }
    } while (choice != 5); // Loop until exit choice is selected

    return 0; // Exit the program
}
