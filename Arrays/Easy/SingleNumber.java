package Arrays.Easy;
// Given a non-empty array of integers nums, 
//every element appears twice except for one. 
//Find that single one.

// You must implement a solution with a linear runtime complexity 
//and use only constant extra space.

 

// Example 1:
// Input: nums = [2,2,1]
// Output: 1

// Example 2:
// Input: nums = [4,1,2,1,2]
// Output: 4

// Example 3:
// Input: nums = [1]
// Output: 1
public class SingleNumber {
    public static int singleNumHash(int[] arr) {
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    int[] hash = new int[max + 1];

    // Count occurrences
    for (int i = 0; i < arr.length; i++) {
        hash[arr[i]]++;
    }

    // Find the element with count 1
    for (int i = 0; i < hash.length; i++) {
        if (hash[i] == 1) {
            return i;
        }
    }

    return -1; // No unique element found
}

    public static int singleNumOptimal(int arr[]){
        //we know a^a=0 and given array all has 
        //2 values of each and one single value 
        //if we xor throught loop we get answer
        int xor=0;
        for(int i=0 ; i<arr.length ; i++){
            xor^=arr[i];
        }
        return xor;
    }
}
