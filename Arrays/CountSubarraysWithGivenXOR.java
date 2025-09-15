package Arrays;
import java.security.Key;
import java.util.HashMap;

public class CountSubarraysWithGivenXOR {

    /*
      Question:
     You are given an integer array `arr[]` and an integer `k`. 
     Find the total number of subarrays whose XOR is equal to `k`.

     Example:
     Input: arr = [4, 2, 2, 6, 4], k = 6
     Output: 4
     Explanation: Subarrays with XOR = 6 are:
                  [4, 2], [2, 6], [6], [4, 2, 2, 6]
    */


    /*
      Intuition (Brute Force):
     - A subarray is defined by its start and end indices (i, j).
     - For each subarray (i...j), compute the XOR and check if it equals k.
     - This requires two nested loops → O(n^2).
    */

    // -------------------------------------------
    // 💡 Brute Force Solution
    // TC: O(n^2), SC: O(1)
    // -------------------------------------------
    public long subarrayXor(int arr[], int k) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor = xor ^ arr[j];  // XOR of subarray (i...j)
                if (xor == k) {
                    count++;
                }
            }
        }

        return count;
    }


    /*
      Intuition (Optimal with HashMap):
     - Let preXor = XOR of elements from index 0...i.
     - For subarray (l...i) to have XOR = k:
       preXor(l-1) ^ preXor(i) = k
       → preXor(l-1) = preXor(i) ^ k
     - This means: if we know how many prefix XORs equal to (preXor ^ k) exist,
       we can count all such subarrays ending at i.
     - Use HashMap to store frequencies of prefix XORs.
     - Iterate once through array → O(n).
    */

    // -------------------------------------------
    // Optimal Solution with HashMap
    // TC: O(n), SC: O(n)
    // -------------------------------------------
    public long subarrayXorOptimal(int arr[], int k) {
        long count = 0;
        int pre = 0;

        // Key   → a prefix XOR value (XOR from index 0…i)  
        // Value → how many times this prefix XOR has occurred so far (frequency)

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case: prefix XOR = 0 occurs once

        for (int i = 0; i < arr.length; i++) {
            pre = pre ^ arr[i];  // prefix XOR till index i

            int rem = pre ^ k;   // required prefix to form subarray with XOR = k

            if (map.containsKey(rem)) {
                count += map.get(rem); // add all such occurrences
            }

            // update frequency of current prefix XOR
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }


    // -------------------------------------------
    //  Test
    // -------------------------------------------
    public static void main(String[] args) {
        CountSubarraysWithGivenXOR obj = new CountSubarraysWithGivenXOR();
        int arr[] = {4, 2, 2, 6, 4};
        int k = 6;

        System.out.println("Brute Force Count = " + obj.subarrayXor(arr, k));       // 4
        System.out.println("Optimal Count     = " + obj.subarrayXorOptimal(arr, k)); // 4
    }
}
