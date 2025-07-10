import java.util.*;
class Basic{
    public static void printNtimes(int n){
        if(n==0) {
            return ;
        }
        System.out.println("Hello\n");
        printNtimes(n-1); // TC -> O(n), SC -> O(n)
    }

    public static void printItoN(int i,int n){
        if(i>n) return;
        System.out.println(i+" ");
        printItoN(i+1, n);
    }
    
    public static void reverseprintItoN(int i,int n){
        if(i<1) return;
        System.out.println(i+" ");
        reverseprintItoN(i-1, n);
    }
    public static int sumOfnNumbers(int n){
        if(n<1){
            return 0;
        }
        return n+sumOfnNumbers(n-1);   //O(n) TC AND SC
    }
    public static int fact(int n){
        if(n<1){
            return 1;
        }
        return n*fact(n-1);   //O(n) TC AND SC
    }
    public static void revArray(int[] arr, int i) {
    int n = arr.length;
    if (i >= n / 2) return;
        
    int temp = arr[i];
    arr[i] = arr[n - i - 1];
    arr[n - i - 1] = temp;

    revArray(arr, i + 1);
}


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        // System.out.println("Enter n: ");
        // int n=sc.nextInt();
        // int i=1 ; 
        // Basic
        // printItoN( i, n);
        // reverseprintItoN(n, n);
        // printNtimes(n);
        System.out.printf("Sum of first n:"+sumOfnNumbers(5));
        System.out.printf("factorial of n:"+fact(5));
        int arr[]={1,2,3,4,5};
        revArray(arr, 0);
    
    // Print the reversed array
        for (int num : arr) {
        System.out.print(num + " ");
    }


        sc.close();
    }
}