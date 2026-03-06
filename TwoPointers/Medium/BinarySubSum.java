class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> prefixSum=new HashMap<>();
        int count=0;
        int sum=0;
        prefixSum.put(0,1); //base : 0 appears once
        
        //iterate through array
        for(int x: nums){
            sum+=x;
            if(prefixSum.containsKey(sum-goal)){
                count+=prefixSum.get(sum-goal);
            }
            //update prefixSum
            prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);
        }
        return count;
    }
}