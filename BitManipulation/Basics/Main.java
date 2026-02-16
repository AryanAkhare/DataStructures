import java.util.*;

class Solution {
    public int distinctPrimeFactors(int[] nums) {
        int n = 1;
        for (int i = 0; i < nums.length; i++) {
            n = n * nums[i];
        }

        int count = 0;
        for (int i = 2; i <= Math.sqrt(n); i = i + 1) {
            if (n % i == 0) {
                count++;
                System.out.print(count);
                while (n % i == 0) {

                    n = n / i;
                    System.out.println(n);
                }
            }
        }

        if (n > 1) count = count + 1;
        return count;

    }
    
    public int distinctPrimeFactors(int[] nums) {
        
        HashSet<Integer> set=new HashSet<>();
        for(int num :  nums){
            int n =num;
            for(int i=2 ; i*i<=n ; i++){
                if(n%i==0) set.add(i);
                while(n%i==0) n=n/i;
            }
            if(n>1) set.add(n);
        }
        return set.size();
    }
    
}


public class Main {
    public static void main(String[] args) {

        int[] nums = {2,14,19,19,5,13,18,10,15,20};

        Solution sol = new Solution();
        int result = sol.distinctPrimeFactors(nums);

        System.out.println("\nFinal Count: " + result);
    }
}
