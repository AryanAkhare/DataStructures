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

    public static int secMax(int a[]){
        int max=a[0];
        for(int x:a){
            if(x>max) max=x;
        }

        int secMax=Integer.MIN_VALUE;
        for(int x:a){
            if(x>secMax && x!=max) secMax=x;
        }
        return secMax;
    }

    public static void main(String[] args) {
        int[] a = {21, 4, 2, 31, 34, 1};
        System.out.println(secondLargest(a));
        System.out.println(secMax(a));  //Output :31
    }
}
