package BitManipulation.Basics;

public class PrimeFactorization {
    import java.util.*;

class Solution {
    public static ArrayList<Integer> primeFac(int n) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 2; i * i <= n; i++) {
            if(n%i==0){
                result.add(i);
            
            while (n % i == 0) {
                
                n = n / i; //remove all occ
            }}
        }
        
        if (n > 1) {
            result.add(n);
        }
        
        return result;
    }
}

