package Arrays;

import java.util.HashMap;

public class LongestSub0sum {
    public int maxLen(int arr[]){
        int n=arr.length;
        int max=0;
        int sum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0 ; i<n ; i++){
            sum+=arr[i];
            if(sum==0)
            {
                max=i+1;
            }
            else{
                if(hm.get(sum)!=null){
                    int len= i - hm.get(sum);
                    max=Math.max(max, len);
                }
                else{
                    hm.put(sum, i);
                }
            }
        }
        return max;
    }
    /**
     * Semi-Optimal Approach using HashMap (Prefix Sum)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * Intuition:
     * - Use a HashMap to store prefix sums and their first occurrence index.
     * - If (current prefix sum - k) exists in map, a subarray with sum k is found.
     * - Also check if prefix sum == k to cover subarrays starting from index 0.
     *for synk*/
    public static int SemiOptimalLongest(int[] a, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            int rem = sum - k;
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // Store the first occurrence of the sum only
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
    //Similar //count allSubsumK
    public static int CountAllSubarraysWithSumK(int[] a, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;

        map.put(0, 1); // To handle case when subarray starts from index 0

        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            int rem = sum - k;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}
