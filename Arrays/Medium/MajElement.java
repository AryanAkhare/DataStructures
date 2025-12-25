/*
 * LeetCode Problem 169: Majority Element
 * ---------------------------------------
 * Given an array `nums` of size `n`, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * 
 * Example:
 * Input: nums = [3, 2, 3]
 * Output: 3
 * 
 * ---------------------------------------
 * Intuition:
 * The Boyer-Moore Voting Algorithm works by maintaining a count and a candidate.
 * - Start with count = 0 and no candidate.
 * - For each number:
 *     - If count is 0, set candidate to current number.
 *     - If number equals candidate, increase count.
 *     - Else, decrease count.
 * - The remaining candidate will be the majority element.
 */
package Arrays.Medium;


public class MajElement {

    public static int majElement(int[] nums){
        int count=0;
        int candidate=0;
        for(int i=0;i<nums.length;i++){
            if(count==0) candidate=nums[i];
            if(nums[i]==candidate) count++;
            else count--;
        }
        return candidate;
    }

   public static int majorityElement(int[] nums) {
    // int count = 0;
    // int candidate = 0;

    // for (int i = 0; i < nums.length; i++) {
    //     if (count == 0) {
    //         candidate = nums[i];
    //     }

    //     if (nums[i] == candidate) {
    //         count++;
    //     } else {
    //         count--;
    //     }
    // }
    int count=0;
    int candidate=0;
    for(int x :nums){
        if(count==0){
            candidate=x;
        }
        if(x==candidate){
            count++;
        }else{
            count--;
        }
    }

    return candidate;


    
}


    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2}; //for given question maj element always exist

        int result = majorityElement(nums);
        System.out.println("Majority element is: " + result);
    }
}
