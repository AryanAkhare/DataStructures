package Arrays;

import static java.lang.Math.max;
// [1,1,0,1,1,1,0,1] op-> 3
// [1,1,0,1,0] op->2
public class MaxConsec1 {
    public static int maxConsec1(int n[]){
        int maxi=0;
        int cnt=0;
        for( int i=0 ; i<n.length;i++){
            if(n[i]==1){
                cnt++;
                maxi=max(maxi,cnt);
            }
            else{
                cnt=0;
            }
        }

        
        return maxi;
    }
}
