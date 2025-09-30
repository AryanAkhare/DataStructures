package Arrays;
import static java.util.Collections.frequency;

import java.util.HashMap;

public class CountSubarraysWithGivenSum {

    /*
      Question:
     Given an integer array 'a' and an integer 'k', 
     count the total number of subarrays whose sum is equal to 'k'.

     Example:
     Input: a = [1, 2, 3, -2, 5], k = 5
     Output: 3
     Explanation: Subarrays with sum 5 are:
                  [2, 3], [5], [1, 2, 3, -2, 1]
    */


    /*
     -------------------------------------------
     🔎 Intuition:
     - A subarray sum can be represented using prefix sums.
     - If prefixSum[j] - prefixSum[i] = k, then the subarray (i+1 ... j) has sum = k.
     - Rearranging: prefixSum[j] - k = prefixSum[i].
     - So, if we know how many prefix sums equal to (prefixSum[j] - k) exist, 
       we can count how many subarrays ending at j have sum = k.
     - Use a HashMap to store frequencies of prefix sums while iterating.
     -------------------------------------------
    */


    // -------------------------------------------
    //  Brute Force (O(n^2)) 
    // -------------------------------------------
    public static int countSubarraysBruteForce(int a[], int k) {
        int count = 0;

        // Try all possible subarrays
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j]; // subarray (i ... j)
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }


    // -------------------------------------------
    //  Optimized (O(n)) using HashMap
    // -------------------------------------------
    public static int countSubarraysWithGivenSum(int a[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

        // key --> prefix sum from index (0 to i);
        // value --> how many times the sum has occured so far (frequency)
        // base case: sum = 0 has occurred once
        map.put(0, 1);

        for (int i = 0; i < a.length; i++) {
            sum += a[i];  // prefix sum till index i

            int rem = sum - k; // check if a subarray sum = k ends at i

            if (map.containsKey(rem)) {
                count += map.get(rem); // add all such occurrences
            }

            // update frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);//map.getOrDefault tries to get frequncy so far , if say it doestn exist it initializes as 0 and we update(+1) as we encountered the prefix again
        }
        //so we basically count map where (pre,freq) and pre==k then we increase count++;
        return count;
    }


    // -------------------------------------------
    //  Test
    // -------------------------------------------
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, -2, 5};
        int k = 5;

        System.out.println("Brute Force Count = " + countSubarraysBruteForce(arr, k));
        System.out.println("Optimized Count   = " + countSubarraysWithGivenSum(arr, k));
    }
}
