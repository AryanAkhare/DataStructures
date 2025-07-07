#include <stdio.h>
#include <stdbool.h>

#define MAX_SIZE 100  // Maximum size of the stack

// Stack structure
char stack[MAX_SIZE];
int top = -1;  // Top index for the stack

// Function to check if the stack is empty
bool isEmpty() {
    return top == -1;
}

// Function to check if the stack is full
bool isFull() {
    return top == MAX_SIZE - 1;
}

// Function to push an element onto the stack
void push(char value) {
    if (!isFull()) {
        stack[++top] = value;  // Push the value onto the stack
    } else {
        printf("Stack Overflow! Cannot push %c\n", value);
    }
}

// Function to pop an element from the stack
char pop() {
    if (!isEmpty()) {
        return stack[top--];  // Return the popped value
    } else {
        printf("Stack Underflow! Cannot pop\n");
        return '\0';  // Return null character if the stack is empty
    }
}

// Function to check if a character is already in the stack
bool existsInStack(char value) {
    for (int i = 0; i <= top; i++) {
        if (stack[i] == value) {
            return true;  // Character already exists
        }
    }
    return false;  // Character does not exist
}

// Function to remove repeated characters from the stack
void removeRepeatedCharacters() {
    char uniqueStack[MAX_SIZE];  // Temporary array to store unique characters
    int uniqueTop = -1;  // Top index for the unique stack

    // Process each character in the original stack
    for (int i = 0; i <= top; i++) {
        if (!existsInStack(stack[i])) {
            push(stack[i]);  // Push the unique character to the stack
        }
    }
}

// Function to display the stack contents
void displayStack() {
    if (isEmpty()) {
        printf("Stack is empty.\n");
    } else {
        printf("Stack contents: ");
        for (int i = 0; i <= top; i++) {
            printf("%c ", stack[i]);
        }
        printf("\n");
    }
}

int main() {
    // Sample input: pushing characters onto the stack
    char input[] = "programming";  // Input string with repeated characters

    // Push characters onto the stack
    for (int i = 0; input[i] != '\0'; i++) {
        push(input[i]);
    }

    printf("Original stack:\n");
    displayStack();

    // Remove repeated characters
    removeRepeatedCharacters();

    printf("Stack after removing repeated characters:\n");
    displayStack();

    return 0;
}
