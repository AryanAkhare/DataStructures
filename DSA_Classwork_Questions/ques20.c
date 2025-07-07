#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int STACK[MAX]; // Array to hold stack elements
int top1 = -1;  // Top index for STACK1 (for odd elements)
int top2 = MAX; // Top index for STACK2 (for even elements)

void push(int value) {
    // Check if value is odd or even
    if (value % 2 != 0) { // Odd
        if (top1 + 1 == top2) { // Check for overflow
            printf("STACK1 Overflow\n");
            return;
        }
        STACK[++top1] = value; // Push to STACK1
        printf("Pushed %d to STACK1\n", value);
    } else { // Even
        if (top2 - 1 == top1) { // Check for overflow
            printf("STACK2 Overflow\n");
            return;
        }
        STACK[--top2] = value; // Push to STACK2
        printf("Pushed %d to STACK2\n", value);
    }
}

int pop(int stackNumber) {
    if (stackNumber == 1) { // Pop from STACK1
        if (top1 == -1) { // Underflow check
            printf("STACK1 Underflow\n");
            return -1;
        }
        return STACK[top1--]; // Return the top element and decrement
    } else if (stackNumber == 2) { // Pop from STACK2
        if (top2 == MAX) { // Underflow check
            printf("STACK2 Underflow\n");
            return -1;
        }
        return STACK[top2++]; // Return the top element and increment
    }
    return -1; // Invalid stack number
}

void displayStacks() {
    printf("STACK1: ");
    for (int i = 0; i <= top1; i++) {
        printf("%d ", STACK[i]);
    }
    printf("\n");

    printf("STACK2: ");
    for (int i = MAX - 1; i >= top2; i--) {
        printf("%d ", STACK[i]);
    }
    printf("\n");
}

int main() {
    push(5); // Odd
    push(10); // Even
    push(15); // Odd
    push(20); // Even
    push(25); // Odd
    push(30); // Even

    displayStacks();

    printf("Popped from STACK1: %d\n", pop(1)); // Pop from STACK1
    printf("Popped from STACK2: %d\n", pop(2)); // Pop from STACK2

    displayStacks();

    return 0;
}
