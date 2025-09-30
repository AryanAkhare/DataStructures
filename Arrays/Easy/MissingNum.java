package Arrays;
// Problem Explanation:
    // Given an array 'nums' containing 'n' distinct numbers in the range [0, n],
    // exactly one number in this range is missing.
    // The task is to find and return that missing number.

    // Example:
    // Input: nums = [3, 0, 1]
    // Range should be: [0, 1, 2, 3] => n = 3
    // Missing number: 2 (since it's not in the array)

public class MissingNum{
    public static int BrutemissingNumber(int[] nums) {
        int n = nums.length; // Total elements in the array

        // Loop through all possible numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            boolean found = false; // Flag to check if 'i' exists in the array

            // Check if the current number 'i' is present in the array
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    found = true; // Mark as found
                    break;        // Exit inner loop early
                }
            }

            // If 'i' was not found, it's the missing number
            if (!found) {
                return i;
            }
        }

        // Should not reach here if input is valid
        return -1;
    }
    public static int BettermissingNumber(int[] nums) {
    int n = nums.length;
    int[] hash = new int[n + 1]; // hash[0 to n]

    for (int i = 0; i < n; i++) {
        hash[nums[i]] = 1;
    }

    for (int i = 0; i <= n; i++) {
        if (hash[i] == 0) {
            return i; // This is the missing number
        }
    }

    return -1; // Shouldn't happen if input is valid
}
public static int optimalMissingNumberSUM(int[] nums) {
    int n=nums.length;
    int sum=n*(n+1)/2;
    int csum=0;
    for ( int i=0;i<n; i++){
        csum+=i;
    }
    return sum-csum;

}
public static int optimalMissingNumberXOR(int[] nums) {
    int n=nums.length;
    int xor1=0;
    
    int xor2=0;
    for( int i=0 ; i< n ; i++){
        xor2^=nums[i];
        xor1^=(i+1);
    }
    return xor1^xor2;

}


    public static void main(String[] args) {
        int a[]={9,6,4,2,3,5,7,0,1,10,11,8,12};
        System.out.println(optimalMissingNumberXOR(a));    }
}