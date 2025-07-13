package Arrays;

import static java.util.Arrays.toString;
import static java.util.Collections.reverse;

import java.util.Arrays;

public class LeftRotate {
    public static void leftRotateByOnePlace(int arr[]){
        int n=arr.length;
        int temp=arr[0];
        for(int i=1; i<arr.length;i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]=temp;
    }
    public static void revFromItoJ(int arr[], int i, int j){
        j=j-1;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public static void leftRotateByKPlace(int arr[],int k){
        k=k%arr.length; //imp step
        revFromItoJ(arr, 0, k);
        revFromItoJ(arr, k, arr.length);
        revFromItoJ(arr, 0, arr.length);
        
    }
    public static void RightRotateByKPlace(int nums[], int k) {
    int n = nums.length;
    k = k % n;

    revFromItoJ(nums, 0, n);         // Reverse entire array
    revFromItoJ(nums, 0, k);         // Reverse first k elements (which are now at the front)
    revFromItoJ(nums, k, n);         // Reverse the remaining n-k elements
}

    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        int k=7;
        //leftRotateByOnePlace(a);
        leftRotateByKPlace(a,k);
        System.out.print(Arrays.toString(a))
        ;
        int b[]=a.clone();
        RightRotateByKPlace(b,k);
        System.out.println(Arrays.toString(b));
        

    }
    
}