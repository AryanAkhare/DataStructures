#include <stdio.h>
#include <string.h>

#define MAX 100 // Maximum number of offline registrations

// Structure to represent a queue
struct Queue {
    char names[MAX][50]; // Array to store names
    int front;           // Front index
    int rear;            // Rear index
};

// Function to initialize the queue
void initQueue(struct Queue* q) {
    q->front = -1; // Set front to -1 to indicate empty
    q->rear = -1;  // Set rear to -1 to indicate empty
}

// Function to check if the queue is empty
int isEmpty(struct Queue q) {
    return (q.front == -1);
}

// Function to add a person to the queue
void enqueue(struct Queue* q, char name[]) {
    if (q->rear == MAX - 1) {
        printf("Queue is full!\n");
        return;
    }
    if (isEmpty(*q)) {
        q->front = 0; // Set front to 0 if queue was empty
    }
    q->rear++;
    strcpy(q->names[q->rear], name);
}

// Function to remove a person from the queue
void dequeue(struct Queue* q, char name[]) {
    if (isEmpty(*q)) {
        printf("Queue is empty!\n");
        return;
    }
    strcpy(name, q->names[q->front]); // Copy the name to the provided variable
    if (q->front >= q->rear) {
        // Reset queue if it becomes empty after dequeue
        q->front = q->rear = -1; 
    } else {
        q->front++;
    }
}

int main() {
    struct Queue offlineQueue; // Create the queue for offline registrations
    initQueue(&offlineQueue);  // Initialize the queue
    char onlineRegistrations[100][50]; // Array to store online registrations
    int onlineCount = 0; // Counter for online registrations

    int choice;
    do {
        printf("\nCovid Vaccination Center Menu:\n");
        printf("1. Register Online\n");
        printf("2. Register Offline\n");
        printf("3. Vaccinate Next Person\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1: {
                char name[50];
                printf("Enter name for online registration: ");
                scanf("%s", name);
                strcpy(onlineRegistrations[onlineCount], name);
                onlineCount++;
                printf("%s registered online successfully!\n", name);
                break;
            }
            case 2: {
                char name[50];
                printf("Enter name for offline registration: ");
                scanf("%s", name);
                enqueue(&offlineQueue, name);
                printf("%s registered offline successfully!\n", name);
                break;
            }
            case 3: {
                if (onlineCount > 0) {
                    printf("%s has been vaccinated (Online Registration)\n", onlineRegistrations[--onlineCount]);
                } else if (!isEmpty(offlineQueue)) {
                    char name[50];
                    dequeue(&offlineQueue, name);
                    printf("%s has been vaccinated (Offline Registration)\n", name);
                } else {
                    printf("No more people to vaccinate.\n");
                }
                break;
            }
            case 4:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice! Please try again.\n");
        }
    } while (choice != 4);

    return 0;
}
