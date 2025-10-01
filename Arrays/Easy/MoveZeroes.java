package Arrays.Easy;

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int arr[]) {
        int n=arr.length;
        int j=0;// Pointer to track position to place the next non-zero element
        // ✅ Step 1: Shift all non-zero elements to the front (preserve their order)
        for(int i=0 ; i< n;i++){
            if(arr[i]!=0){
                arr[j]=arr[i]; // Place current non-zero at position j
                j++; // Move j forward
            }
        }
        // ❗ At this point, the first 'j' elements are non-zero.
        // All remaining positions should be filled with zero.
        while(j<n){
            arr[j]=0;
            j++;
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,42,0,45,22,9,0,0,21323,043421,0,0,0,13123,13,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
