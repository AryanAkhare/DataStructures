package Arrays;
// ✅ LeetCode 26 – Remove Duplicates from Sorted Array
// 📄 Problem (Short):
// Given a sorted array, remove the duplicates in-place such that each unique element appears only once, and return the new length.

// You must do it using O(1) extra space (i.e., modify the array in-place).

// 🔍 Intuition:
// Since the array is sorted, all duplicates will be together.
// We can use a two-pointer approach:
// i keeps track of the last unique element
// j moves forward through the array
// Whenever nums[j] != nums[i], it's a new element → move it to the front

//Examples
// Input: [1, 1, 2]
// → After operation: [1, 2, _]
// → Output: 2

// Input: [1, 2, 2, 3, 3, 4]
// → After operation: [1, 2, 3, 4, _ , _]
// → Output: 4
public class RemoveDuplicates {
    
    public static int removeDuplicates(int[] nums) {
        int i=0;
        for ( int j=0 ; j<nums.length; j++){
            if(nums[i]!=nums[j]){
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
    }

    
    public static void main(String[] args) {
        int a[]={1,1,2};
        int b[]={1,2,2,3,3,4,4,5,5,6,7};
        System.out.println(removeDuplicates(a)); // returns 2 duplicates
        System.out.println(removeDuplicates(b)); //return 7 duplicates
    }

}
