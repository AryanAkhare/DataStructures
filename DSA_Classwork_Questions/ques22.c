#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 100  // Maximum size of the stack

// Stack structure
int stack1[MAX_SIZE];
int stack2[MAX_SIZE];
int top1 = -1;  // Top index for stack1
int top2 = -1;  // Top index for stack2

// Function to check if the stack is full
int isFull(int top) {
    return top == MAX_SIZE - 1;
}

// Function to check if the stack is empty
int isEmpty(int top) {
    return top == -1;
}

// Function to push an element onto the stack
void push(int stack[], int* top, int value) {
    if (isFull(*top)) {
        printf("Stack Overflow! Cannot push %d\n", value);
    } else {
        stack[++(*top)] = value;  // Push the value onto the stack
        printf("Pushed %d onto stack\n", value);
    }
}

// Function to pop an element from the stack
int pop(int stack[], int* top) {
    if (isEmpty(*top)) {
        printf("Stack Underflow! Cannot pop\n");
        return -1;  // Return -1 if the stack is empty
    } else {
        return stack[(*top)--];  // Return the popped value
    }
}

// Function to copy stack1 to stack2
void copyStack() {
    // Temporary stack to hold the elements while copying
    int tempStack[MAX_SIZE];
    int tempTop = -1;

    // Pop all elements from stack1 and push them onto the temporary stack
    while (!isEmpty(top1)) {
        int value = pop(stack1, &top1);
        tempStack[++tempTop] = value;  // Push to temp stack
    }

    // Pop from the temporary stack to stack2 to maintain the order
    while (tempTop != -1) {
        int value = tempStack[tempTop--];  // Pop from temp stack
        stack2[++top2] = value;  // Push to stack2
    }
}

int main() {
    // Push some values onto stack1
    push(stack1, &top1, 10);
    push(stack1, &top1, 20);
    push(stack1, &top1, 30);
    push(stack1, &top1, 40);
    
    // Copy stack1 to stack2
    copyStack();

    // Display the contents of stack2
    printf("Contents of stack2 after copying from stack1:\n");
    while (!isEmpty(top2)) {
        printf("%d\n", pop(stack2, &top2));
    }

    return 0;
}
