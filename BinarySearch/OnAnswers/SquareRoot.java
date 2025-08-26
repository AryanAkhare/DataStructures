package OnAnswers;

public class SquareRoot {
    
    int floorSqrt(int n) {
        // code here
        int ans=1;
        int low=1;
        int high=n;
        while(low<=high){
            int mid = low +(high-low)/2;
            long square= (long) mid*mid;
            
            if(square<=n){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    
}
}
