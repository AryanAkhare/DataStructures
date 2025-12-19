package Arrays.Medium;
import java.util.*;
public class CountMaxTriangle {
    
    public int countTriangles(int arr[]) {
        // code here
        int ans=0;
        
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=2 ; i< n ; i++){
            int left=0;
            int right=i-1;
            while(left<right){
                if(arr[left]+arr[right]>arr[i]){
                    ans+=right-left;
                    right--;
                    
                }
                else{
                    left++;
                }
            }
        }
        return ans;
    }
}

