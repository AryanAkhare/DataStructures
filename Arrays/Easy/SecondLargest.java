package Arrays.Easy;

public class SecondLargest {
    
    public static int secondLargest(int a[]){
        int max = a[0];  // Start with the first value
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];  // Update max if current element is greater
            }
        }
        
        int secmax=Integer.MIN_VALUE;
        for( int i=0 ; i<a.length;i++){
            if(a[i]>secmax && a[i]!=max){
                secmax=a[i];
            }
        }
        return secmax;
    }

    public static void main(String[] args) {
        int[] a = {21, 4, 2, 31, 34, 1};
        System.out.println(secondLargest(a));  //Output :31
    }
}
