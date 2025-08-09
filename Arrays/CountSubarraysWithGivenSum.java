package Arrays;
import java.util.HashMap;
public class CountSubarraysWithGivenSum {
    public static int countSubarraysWithGivenSum(int a[],int k){
    HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int count=0;
    //📌 Key: Integer → The prefix sum
    //📌 Value: Integer → The count (frequency) of how many times that prefix sum has occurred
        map.put(0,1); //0 prefix sum and 1 is frequence

        for(int i=0;i<a.length;i++){
            sum+=a[i];
            int rem=sum-k;
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
        }
        /*rem = sum - k: This is the key idea. If rem exists in the map, it means a subarray with sum = k exists ending at the current index.
         * 
         * map.get(rem): Returns how many times that rem has occurred before.

        count: Keeps track of the total number of valid subarrays found so far.
         */
        map.put(sum, map.getOrDefault(sum,0)+1);
        return count;
    } 
}
