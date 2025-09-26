package Arrays.Hard;
public class MaxProductSubarray {
    public static int brutemaxprosub(int arr[]){
        int n=arr.length;
        int max=Integer.MIN_VALUE;

        for (int i=0 ; i< n ; i++){
            int product=1;
            for(int j=i ; j < n ; j++){
                product*=arr[j];
                max=Math.max(max, product);
            }
        }
        return max;
    }
    //O of n^2 complexity
    //Space O(1)
    public  static int OptimalmaxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int pre=1;
        int suff=1;

        for (int i = 0; i < n; i++) {
            if(pre==0) { pre=1; }
            if(suff==0) { suff=1; }

            pre=pre*nums[i];
            suff=suff*nums[n-i-1];
            max=Math.max(max,Math.max(pre,suff));
        }

        return max;
    }
    public static int KadaneMethod(int [] nums){
         int n = nums.length;
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            int curr = nums[i];

            // If current number is negative, swap max & min
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}
