#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <float.h>

#define MAX_POINTS 100  // Maximum number of points

// Structure to represent a point
struct Point {
    double x, y;
};

// Function to calculate distance between two points
double calculateDistance(struct Point p1, struct Point p2) {
    // O(1) time complexity: simple arithmetic operations
    return sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
}

// Merge function to merge two halves of the array based on either x or y-coordinate
void merge(struct Point points[], int left, int right, int sortByX) {
    // O(log n) recursion for dividing the array
    if (left >= right) return;

    int middle = (left + right) / 2;
    merge(points, left, middle, sortByX);        // Sort left half (recursive)
    merge(points, middle + 1, right, sortByX);   // Sort right half (recursive)

    int leftSize = middle - left + 1;
    int rightSize = right - middle;

    struct Point leftArray[leftSize], rightArray[rightSize];
    for (int i = 0; i < leftSize; i++) leftArray[i] = points[left + i];
    for (int i = 0; i < rightSize; i++) rightArray[i] = points[middle + 1 + i];

    int i = 0, j = 0, k = left;
    while (i < leftSize && j < rightSize) {
        // O(n) for merging elements
        if (sortByX) {  // Sorting by x-coordinate
            if (leftArray[i].x <= rightArray[j].x) {
                points[k++] = leftArray[i++];
            } else {
                points[k++] = rightArray[j++];
            }
        } else {  // Sorting by y-coordinate
            if (leftArray[i].y <= rightArray[j].y) {
                points[k++] = leftArray[i++];
            } else {
                points[k++] = rightArray[j++];
            }
        }
    }

    // Copy remaining elements (O(n) for each merge)
    while (i < leftSize) points[k++] = leftArray[i++];
    while (j < rightSize) points[k++] = rightArray[j++];
}

/*
    Time Complexity of merge function:
    - Sorting by X: O(n log n) for the entire merge sort process
    - Merging two halves: O(n) at each level of recursion
*/

// Function to find the closest pair in the middle strip
double findClosestInStrip(struct Point strip[], int stripSize, double minDist) {
    double closestDist = minDist;
    // Sorting strip by y-coordinate (O(n log n) complexity)
    merge(strip, 0, stripSize - 1, 0);  // Sort strip by y-coordinate

    // O(n) for checking pairs in the strip
    for (int i = 0; i < stripSize; i++) {
        for (int j = i + 1; j < stripSize && (strip[j].y - strip[i].y) < closestDist; j++) {
            double dist = calculateDistance(strip[i], strip[j]);
            if (dist < closestDist) {
                closestDist = dist;
            }
        }
    }
    return closestDist;
}

/*
    Time Complexity of findClosestInStrip function:
    - Sorting the strip by y-coordinate: O(n log n)
    - Checking pairs in the strip: O(n)
*/

// Recursive function to find the closest pair
double findClosestPair(struct Point points[], int numPoints) {
    // Base case: If there's only 1 point or less, no closest pair exists
    if (numPoints <= 1) return DBL_MAX;  // O(1) since no pair can be found

    int middle = numPoints / 2;
    struct Point middlePoint = points[middle];

    // Recursively find closest pair in left and right halves
    double leftClosest = findClosestPair(points, middle);  // O(n log n) for each recursive call
    double rightClosest = findClosestPair(points + middle, numPoints - middle);  // O(n log n)
    double closestDist = fmin(leftClosest, rightClosest);

    // Collect points close to the middle line (O(n))
    struct Point strip[MAX_POINTS];
    int stripSize = 0;
    for (int i = 0; i < numPoints; i++) {
        if (fabs(points[i].x - middlePoint.x) < closestDist) {
            strip[stripSize++] = points[i];
        }
    }

    // Check closest pair in the strip (O(n) for this part)
    return fmin(closestDist, findClosestInStrip(strip, stripSize, closestDist));
}

/*
    Time Complexity of findClosestPair function:
    - Recursive calls: O(n log n) for dividing the points
    - Checking the strip: O(n) at each level
*/

// Wrapper function
double closestPair(struct Point points[], int numPoints) {
    // Sorting points by x-coordinate (O(n log n))
    merge(points, 0, numPoints - 1, 1);  // Sort the points by x-coordinate
    return findClosestPair(points, numPoints);  // O(n log n) recursion
}

/*
    Time Complexity of closestPair function:
    - Sorting points: O(n log n)
    - Recursive closest pair calculation: O(n log n)
*/

// Main function
int main() {
    struct Point points[MAX_POINTS];
    int numPoints;

    printf("Enter the number of points: ");
    scanf("%d", &numPoints);

    printf("Enter the points (x y):\n");
    for (int i = 0; i < numPoints; i++) {
        scanf("%lf %lf", &points[i].x, &points[i].y);
    }

    // Find the closest pair and print the result
    double minDist = closestPair(points, numPoints);
    printf("The smallest distance is: %.6f\n", minDist);

    return 0;
}
