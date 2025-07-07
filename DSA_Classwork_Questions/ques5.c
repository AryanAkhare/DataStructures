#include <stdio.h>

#define MAX_ONE_D 100  // Maximum size for 1D array
#define MAX_TWO_D 10   // Maximum rows for 2D array
#define MAX_COLS 10    // Maximum columns for 2D array
#define MAX_THREE_D 5  // Maximum layers for 3D array
#define MAX_ROWS_3D 10 // Maximum rows for 3D array
#define MAX_COLS_3D 10 // Maximum columns for 3D array

int main() {
    int oneDSize, twoDRows, twoDCols;
    int threeDLayers, threeDRows, threeDCols;

    // User-defined size for 1D array
    printf("Enter size for 1D array (max %d): ", MAX_ONE_D);
    scanf("%d", &oneDSize);
    
    // Check for valid size
    if (oneDSize > MAX_ONE_D) {
        printf("Size exceeds maximum limit for 1D array.\n");
        return 1;
    }

    // Declare 1D array
    int oneDArray[MAX_ONE_D];
    
    // Input elements for the 1D array
    printf("Enter %d elements for the 1D array:\n", oneDSize);
    for (int i = 0; i < oneDSize; i++) {
        scanf("%d", &oneDArray[i]);
    }

    // User-defined size for 2D array
    printf("Enter number of rows for 2D array (max %d): ", MAX_TWO_D);
    scanf("%d", &twoDRows);
    printf("Enter number of columns for 2D array (max %d): ", MAX_COLS);
    scanf("%d", &twoDCols);
    
    // Check for valid size
    if (twoDRows > MAX_TWO_D || twoDCols > MAX_COLS) {
        printf("Size exceeds maximum limit for 2D array.\n");
        return 1;
    }

    // Declare 2D array
    int twoDArray[MAX_TWO_D][MAX_COLS];
    
    // Input elements for the 2D array
    printf("Enter elements for the 2D array (%d x %d):\n", twoDRows, twoDCols);
    for (int i = 0; i < twoDRows; i++) {
        for (int j = 0; j < twoDCols; j++) {
            scanf("%d", &twoDArray[i][j]);
        }
    }

    // User-defined size for 3D array
    printf("Enter number of layers for 3D array (max %d): ", MAX_THREE_D);
    scanf("%d", &threeDLayers);
    printf("Enter number of rows for 3D array (max %d): ", MAX_ROWS_3D);
    scanf("%d", &threeDRows);
    printf("Enter number of columns for 3D array (max %d): ", MAX_COLS_3D);
    scanf("%d", &threeDCols);
    
    // Check for valid size
    if (threeDLayers > MAX_THREE_D || threeDRows > MAX_ROWS_3D || threeDCols > MAX_COLS_3D) {
        printf("Size exceeds maximum limit for 3D array.\n");
        return 1;
    }

    // Declare 3D array
    int threeDArray[MAX_THREE_D][MAX_ROWS_3D][MAX_COLS_3D];
    
    // Input elements for the 3D array
    printf("Enter elements for the 3D array (%d x %d x %d):\n", threeDLayers, threeDRows, threeDCols);
    for (int i = 0; i < threeDLayers; i++) {
        for (int j = 0; j < threeDRows; j++) {
            for (int k = 0; k < threeDCols; k++) {
                scanf("%d", &threeDArray[i][j][k]);
            }
        }
    }

    // Display addresses of the 1D array elements
    printf("\nAddresses of elements in the 1D array:\n");
    for (int i = 0; i < oneDSize; i++) {
        printf("Address of oneDArray[%d]: %p\n", i, (void*)&oneDArray[i]);
    }

    // Display addresses of the 2D array elements
    printf("\nAddresses of elements in the 2D array:\n");
    for (int i = 0; i < twoDRows; i++) {
        for (int j = 0; j < twoDCols; j++) {
            printf("Address of twoDArray[%d][%d]: %p\n", i, j, (void*)&twoDArray[i][j]);
        }
    }

    // Display addresses of the 3D array elements
    printf("\nAddresses of elements in the 3D array:\n");
    for (int i = 0; i < threeDLayers; i++) {
        for (int j = 0; j < threeDRows; j++) {
            for (int k = 0; k < threeDCols; k++) {
                printf("Address of threeDArray[%d][%d][%d]: %p\n", i, j, k, (void*)&threeDArray[i][j][k]);
            }
        }
    }

    return 0;
}
    
